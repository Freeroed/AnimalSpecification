package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.TypeOfAnimal;

public interface TypeOfAnimalRepository extends CrudRepository<TypeOfAnimal, Long> {
}
