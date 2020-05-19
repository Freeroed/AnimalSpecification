package ru.vlsu.animalSpecification.service.mapper;

import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.Document;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.service.dto.AnimalDTO;
import ru.vlsu.animalSpecification.service.dto.DocumentDTO;
import ru.vlsu.animalSpecification.service.dto.RequestDTO;
import ru.vlsu.animalSpecification.service.dto.UserDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RequestMapper {
  private final AnimalMapper animalMapper;

  private final DocumentMapper documentMapper;

  public RequestMapper(AnimalMapper animalMapper, DocumentMapper documentMapper) {
    this.animalMapper = animalMapper;
    this.documentMapper = documentMapper;
  }

  public List<RequestDTO> requestsToRequestsDTO(List<Request> requests){
    return requests.stream()
      .filter(Objects::nonNull)
      .map(this::requestToRequestDTO)
      .collect(Collectors.toList());
  }

  public RequestDTO requestToRequestDTO(Request request) {
    RequestDTO requestDTO = new RequestDTO(request);
    Set<Animal> animals = request.getAnimals();
    requestDTO.setAnimals(animalsToAnimalsDTO(animals));
    requestDTO.setCertificate1FormNumber(documentMapper.toDTO(request.getCertificate1FormNumber()));
    requestDTO.setCertificate5aFormNumber(documentMapper.toDTO(request.getCertificate5aFormNumber()));
    requestDTO.setCertificateEuroNumber(documentMapper.toDTO(request.getCertificateEuroNumber()));
    return requestDTO;
  }

  public Request toEntity(RequestDTO requestDTO) {
      if (requestDTO == null ) {
        return  null;
      } else {
        //TODO DTO for all classes
        Request request = new Request();
        request.setId(requestDTO.getId());
        request.setRecipient(userFromUserDTO(requestDTO.getRecipient()));
        request.setDestinationCountry(requestDTO.getDestinationCountry());
        request.setDestinationCity(requestDTO.getDestinationCity());
        request.setBorderCrossingPoint(requestDTO.getBorderCrossingPoint());
        request.setTransactionType(requestDTO.getTransactionType());
        request.setVehicleNumber(requestDTO.getVehicleNumber());
        request.setVeterinarian(userFromUserDTO(requestDTO.getVeterinarian()));
        request.setTransactionType(requestDTO.getTransactionType());
        request.setWayOfStorageDuringTransportation(requestDTO.getWayOfStorageDuringTransportation());
        request.setQuarantineLocation(requestDTO.getQuarantineLocation());
        request.setInspectorOfRosselkhoznadzor(userFromUserDTO(requestDTO.getInspectorOfRosselkhoznadzor()));
        request.setPostalCode(requestDTO.getPostalCode());
        request.setDateOfDeparture(requestDTO.getDateOfDeparture());
        request.setCertificate1FormNumber(documentDTOtoDocument(requestDTO.getCertificate1FormNumber()));
        request.setAnimals(animalsDTOToAnimals(requestDTO.getAnimals()));
        request.setStatus(requestDTO.getStatus());
        request.setTransport(requestDTO.getTransport());
        request.setCertificateEuroNumber(documentDTOtoDocument(requestDTO.getCertificateEuroNumber()));
        request.setCertificate5aFormNumber(documentDTOtoDocument(requestDTO.getCertificate5aFormNumber()));
        request.setCreatedAt(requestDTO.getCreatedAt());
        request.setRequestNumber(requestDTO.getRequestNumber());
        return request;
      }

  }

  private User userFromUserDTO(UserDTO userDTO) {
    if (userDTO != null) {
    User user = new User();
      user.setId(userDTO.getId());

    return user;
    } else {
      return null;
    }
  }

  private Set<Animal> animalsDTOToAnimals(Set<AnimalDTO> animalsDTO) {
    Set<Animal> animals = new HashSet<>();
    if ( animalsDTO != null ) {
      animals = animalsDTO.stream().map(animalDTO -> {
        Animal animal = new Animal();
        animal.setId(animalDTO.getId());
        return animal;
      }).collect(Collectors.toSet());
    }
    return animals;
  }

  private Set<AnimalDTO> animalsToAnimalsDTO(Set<Animal> animals) {
    Set<AnimalDTO> animalsDTO = new HashSet<>();
    if (animals != null ) {
      animalsDTO = animals.stream().map(animal -> {
        AnimalDTO animalDTO = animalMapper.animalToAnimalsDTO(animal);
        return animalDTO;
      }).collect(Collectors.toSet());
    }
    return animalsDTO;
  }

  private Document documentDTOtoDocument(DocumentDTO documentDTO) {
    if (documentDTO == null) {
      return  null;
    } else {
      Document document = new Document();
      document.setId(documentDTO.getId());
      return document;
    }
  }


}
