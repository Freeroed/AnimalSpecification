package ru.vlsu.animalSpecification.service.mapper;

import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.service.dto.AnimalDTO;

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
}
