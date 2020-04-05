package ru.vlsu.animalSpecification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.BreedsOfAnimal;
import ru.vlsu.animalSpecification.domain.TypeOfAnimal;

import java.util.List;

public interface BreedsOfAnimalRepository extends JpaRepository<BreedsOfAnimal, Long> {
  List<BreedsOfAnimal> getAllByAnimalType(TypeOfAnimal typeOfAnimal);
}
