package ru.vlsu.animalSpecification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.User;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

  List<Animal> findAllByMaster(User master);

  void deleteById(Long id);

  List<Animal> findAll();
}
