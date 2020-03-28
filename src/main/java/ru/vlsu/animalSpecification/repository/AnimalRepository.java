package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.Animal;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

  List<Animal> findAllByHuman(Long human);

  void deleteById(Long id);
}
