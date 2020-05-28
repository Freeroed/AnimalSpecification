package ru.vlsu.animalSpecification.service.mapper;

import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.BreedsOfAnimal;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.service.dto.AnimalDTO;
import ru.vlsu.animalSpecification.service.dto.BreedsOfAnimalDTO;
import ru.vlsu.animalSpecification.service.dto.UserDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AnimalMapper {

  public List<AnimalDTO> animalsToAnimalsDTO(List<Animal> animals) {
    return animals.stream()
      .filter(Objects::nonNull)
      .map(this::animalToAnimalsDTO)
      .collect(Collectors.toList());
  }

  public AnimalDTO animalToAnimalsDTO(Animal animal) {
    return new AnimalDTO(animal);
  }


  public Animal toEntity(AnimalDTO animalDTO) {
      if (animalDTO == null) {
        return null;
      } else {
        Animal animal = new Animal();
        animal.setId(animalDTO.getId());
        animal.setNickname(animalDTO.getNickname());
        animal.setChip(animalDTO.getChip());
        animal.setSex(animalDTO.getSex());
        animal.setBirthday(animalDTO.getBirthday());
        animal.setBreed(breedFromBreedDTO(animalDTO.getBreed()));
        animal.setColor(animalDTO.getColor());
        animal.setPlaceOfBirth((animalDTO.getPlaceOfBirth()));
        animal.setMaster(userFromUserDTO(animalDTO.getMaster()));
        animal.setTnvedCode(animalDTO.getTnvedCode());
        animal.setStatus(animalDTO.getStatus());
        animal.setColorENG(animalDTO.getColorENG());
        return animal;
      }
  }

  public BreedsOfAnimal breedFromBreedDTO(BreedsOfAnimalDTO breedsOfAnimalDTO) {
      if (breedsOfAnimalDTO == null) {
        return  null;
      } else {
        BreedsOfAnimal breed = new BreedsOfAnimal();
        breed.setId(breedsOfAnimalDTO.getId());
        return breed;
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
}
