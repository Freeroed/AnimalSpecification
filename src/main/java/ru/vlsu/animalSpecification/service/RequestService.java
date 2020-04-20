package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.domain.emun.RequestStatus;
import ru.vlsu.animalSpecification.repository.RequestRepository;
import ru.vlsu.animalSpecification.service.dto.RequestDTO;
import ru.vlsu.animalSpecification.service.mapper.RequestMapper;

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

    @Autowired
    public RequestService(RequestRepository repo, UserService userService, RequestMapper requestMapper) {
      this.repo = repo;
      this.userService = userService;
      this.requestMapper = requestMapper;
    }

    public RequestDTO save(RequestDTO req, String userName) {
        log.debug("Request save request : {} by user with userName : {}", req, userName);
        User master = userService.findByUsername(userName);
        Request request = requestMapper.toEntity(req);
        if (request.getId() == null) {
          request.setRecipient(master);
          request.setStatus(RequestStatus.CREATED);
          request.setCreatedAt(Instant.now());
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
