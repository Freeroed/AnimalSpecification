package ru.vlsu.animalSpecification.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.service.dto.AnimalDTO;

import java.util.List;
import java.util.Optional;

public interface AnimalService {

  AnimalDTO save(Animal animal, String username);

  Page<AnimalDTO> findAll(Pageable pageable);

  Optional<AnimalDTO> findOne(Long id);

  void delete(Long id);

  List<AnimalDTO> listAll();

  List<AnimalDTO> findByUser(String userName);

}
