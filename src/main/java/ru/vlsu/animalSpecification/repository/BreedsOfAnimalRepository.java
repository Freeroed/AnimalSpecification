package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.BreedsOfAnimal;

public interface BreedsOfAnimalRepository extends CrudRepository<BreedsOfAnimal, Long> {
}
