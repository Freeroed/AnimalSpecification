package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.BreedsOfAnimal;
import ru.vlsu.animalSpecification.repository.BreedsOfAnimalRepository;

import java.util.List;

@Service
@Transactional
public class BreedsOfAnimalService {

    private static final Logger log = LoggerFactory.getLogger(BreedsOfAnimalService.class);

    private final BreedsOfAnimalRepository repo;

    @Autowired
    public BreedsOfAnimalService(BreedsOfAnimalRepository repo) {
      this.repo = repo;
    }

  public List<BreedsOfAnimal> listAll() {
        return (List<BreedsOfAnimal>)repo.findAll();
    }

    public List <BreedsOfAnimal> getByType(Long id) {
      log.debug("Find brees by animal type id: " + id);
      List <BreedsOfAnimal> res = null;
      try {
        res = repo.getAllByAnimalType(id);
      } catch (Exception e){
        log.debug("Error finding brees by animal type with id. Exc: " + e.getMessage());
      }
      return res;
    }
}
