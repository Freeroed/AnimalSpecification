package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.TypeOfAnimal;
import ru.vlsu.animalSpecification.repository.TypeOfAnimalRepository;

import java.util.List;

@Service
@Transactional
public class TypeOfAnimalService {

    private static final Logger log = LoggerFactory.getLogger(TypeOfAnimalService.class);

    private final TypeOfAnimalRepository repo;

    @Autowired
    public TypeOfAnimalService(TypeOfAnimalRepository repo) {
      this.repo = repo;
    }

  public List<TypeOfAnimal> listAll() {
        log.debug("Get all types of animals");
        return (List<TypeOfAnimal>) repo.findAll();
    }
}
