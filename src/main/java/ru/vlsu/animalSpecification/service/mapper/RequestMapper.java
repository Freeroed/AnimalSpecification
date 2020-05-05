package ru.vlsu.animalSpecification.service.mapper;

import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.service.dto.AnimalDTO;
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

  public RequestMapper(AnimalMapper animalMapper) {
    this.animalMapper = animalMapper;
  }

  public List<RequestDTO> requestsToRequestsDTO(List<Request> requests){
    return requests.stream()
      .filter(Objects::nonNull)
      .map(this::requestToRequestDTO)
      .collect(Collectors.toList());
  }

  public RequestDTO requestToRequestDTO(Request request) {
    RequestDTO requestDTO = new RequestDTO(request);
    requestDTO.setAnimals(animalsToAnimalsDTO(request.getAnimals()));
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
        request.setCertificate1FormNumber(requestDTO.getCertificate1FormNumber());
        request.setAnimals(animalsDTOToAnimals(requestDTO.getAnimals()));
        request.setStatus(requestDTO.getStatus());
        request.setTransport(requestDTO.getTransport());
        request.setCertificateEuroNumber(requestDTO.getCertificateEuroNumber());
        request.setCertificate5aFormNumber(requestDTO.getCertificate5aFormNumber());
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


}
