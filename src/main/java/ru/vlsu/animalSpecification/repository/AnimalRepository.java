package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
