package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.Document;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.domain.emun.AnimalStatus;
import ru.vlsu.animalSpecification.domain.emun.RequestStatus;
import ru.vlsu.animalSpecification.repository.RequestRepository;
import ru.vlsu.animalSpecification.service.dto.DocumentDTO;
import ru.vlsu.animalSpecification.service.dto.RequestDTO;
import ru.vlsu.animalSpecification.service.mapper.AnimalMapper;
import ru.vlsu.animalSpecification.service.mapper.DocumentMapper;
import ru.vlsu.animalSpecification.service.mapper.RequestMapper;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RequestService {

    private static final Logger log = LoggerFactory.getLogger(RequestService.class);


    private final RequestRepository repo;

    private final UserService userService;

    private final RequestMapper requestMapper;

    private final DocumentService documentService;

    private final DocumentMapper documentMapper;

    private final IdentificatorGenerationService identificatorGenerationService;
    private final AnimalService animalService;
    private final AnimalMapper animalMapper;

    @Autowired
    public RequestService(RequestRepository repo, UserService userService, RequestMapper requestMapper, DocumentService documentService, DocumentMapper documentMapper, IdentificatorGenerationService identificatorGenerationService, AnimalService animalService, AnimalMapper animalMapper) {
      this.repo = repo;
      this.userService = userService;
      this.requestMapper = requestMapper;
      this.documentService = documentService;
      this.documentMapper = documentMapper;
      this.identificatorGenerationService = identificatorGenerationService;
      this.animalService = animalService;
      this.animalMapper = animalMapper;
    }

    public RequestDTO save(RequestDTO req, String userName) {
        log.debug("Request save request : {} by user with userName : {}", req, userName);
        User master = userService.findByUsername(userName);
        Request request = requestMapper.toEntity(req);
        //Check creating new request
        if (request.getId() == null) {
          request.setRecipient(master);
          request.setStatus(RequestStatus.CREATED);
          request.setCreatedAt(Instant.now());
          request.setRequestNumber(identificatorGenerationService.generateRequestNumber(master.getId()));
        } else {
          if(request.getStatus() == RequestStatus.CREATED) {
            for(Animal animal: request.getAnimals()) {
              Animal updatedAnimal = animalMapper.toEntity(animalService.findOne(animal.getId()).get());
              updatedAnimal.setStatus(AnimalStatus.IN_REQUEST);
              animalService.save(updatedAnimal,userName);
            }
          }
          if (request.getStatus() == RequestStatus.CONFIRM) {
            for(Animal animal: request.getAnimals()) {
              Animal updatedAnimal = animalMapper.toEntity(animalService.findOne(animal.getId()).get());
              updatedAnimal.setStatus(AnimalStatus.IN_CONFIRM_REQUEST);
              animalService.save(updatedAnimal,userName);
            }
          }
          if (request.getStatus() == RequestStatus.FROM_ONE_SERTIFICATED) {
            RequestDTO oldRequest = findOne(request.getId()).get();
            if (oldRequest.getStatus() == RequestStatus.CONFIRM && oldRequest.getVeterinarian() == null && oldRequest.getCertificate1FormNumber() == null) {
              //TODO check user role
              request.setVeterinarian(master);
             /* try {
                //RequestDTO requestDTO = requestMapper.requestToRequestDTO(request);
                DocumentDTO doc = documentService.createDocumentFromRequest(request, "Ветеринарный сертификат формы 1");
                Document document = documentMapper.toEntity(doc);
                request.setCertificate1FormNumber(document);
              } catch (IOException e) {
                log.debug("EROORR CREATING FILE");
              }*/
            }
          }
          if (request.getStatus() == RequestStatus.EXPORT_DOCS_ISSUED) {
            RequestDTO oldRequest = findOne(request.getId()).get();
            if (oldRequest.getStatus() == RequestStatus.FROM_ONE_SERTIFICATED &&
              oldRequest.getInspectorOfRosselkhoznadzor() == null &&
              oldRequest.getCertificate5aFormNumber() == null  &&
              oldRequest.getCertificateEuroNumber() == null) {
                request.setInspectorOfRosselkhoznadzor(master);
                request = repo.save(request);
                for(Animal animal: request.getAnimals()) {
                  Animal updatedAnimal = animalMapper.toEntity(animalService.findOne(animal.getId()).get());
                  updatedAnimal.setStatus(AnimalStatus.READY_TO_REQUEST);
                  animalService.save(updatedAnimal,userName);
                }
                try {
                  DocumentDTO euroCertificate = documentService.createDocumentFromRequest(request, "Евросправка");
                  Document document = documentMapper.toEntity(euroCertificate);
                  request.setCertificateEuroNumber(document);
                  DocumentDTO formFiveCertificate = documentService.createDocumentFromRequest(request, "Ветеринарный сертификат формы 5а");
                  document = documentMapper.toEntity(formFiveCertificate);
                  request.setCertificate5aFormNumber(document);
                }
                catch (IOException e) {
                  log.error("CREATING FILE ERROR");
                }

            }
          }

        }
      Request result = repo.save(request);
      return requestMapper.requestToRequestDTO(result);
    }

    public List<RequestDTO> listAll()
    {
        return requestMapper.requestsToRequestsDTO(repo.findAll());
    }

    public Request get(Long id) {
        log.debug("Find request by id: {}", id);
        Request res = null;
        try {
          res = repo.findById(id).get();
        } catch (Exception e){
          log.error("Error finding request by id: " + e.getMessage());
          log.trace(e.getStackTrace().toString());
        }
        return res;
    }

    public Optional<RequestDTO> findOne(Long id) {
      log.debug("Request to get request by id : {}", id);
      return  repo.findFirstById(id).map(requestMapper::requestToRequestDTO);
    }

    public void delete(Long id) {
        log.debug("Delete request with id: {}", id);
        repo.deleteById(id);
    }

    public List<RequestDTO> findRequestByUser(String userName) {
      log.debug("Request to get requests by user with userName : {}", userName);
      User recipient = userService.findByUsername(userName);
      if (recipient != null) {
        List<Request> requests = repo.findAllByRecipient(recipient);
        if (requests != null ) {
          return requestMapper.requestsToRequestsDTO(requests);
        } else return null;
      } else {
        return null;
      }
    }

}
