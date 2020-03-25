package ru.vlsu.animalSpecification.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.service.dto.AnimalDTO;

import java.util.List;
import java.util.Optional;

public interface AnimalService {

  Animal save(Animal animal, String username);

  Page<Animal> findAll(Pageable pageable);

  Optional<Animal> findOne(Long id);

  void delete(Long id);

  List<Animal> listAll();

  List<Animal> findByUser(Long userId);
}
