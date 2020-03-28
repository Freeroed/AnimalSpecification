package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.User;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

  List<Animal> findAllByMaster(User master);

  void deleteById(Long id);

  List<Animal> findAll();
}
