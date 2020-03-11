package ru.vlsu.animalSpecification.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.repository.AnimalRepository;

import java.util.List;

@Service
@Transactional
public class AnimalService {
    @Autowired
    private AnimalRepository repo;

    private static final Logger log = Logger.getLogger(AnimalService.class);

    public List<Animal> listAll() {
        //log.debug("Request to get all animals");
        return (List<Animal>) repo.findAll();
    }

    public Animal get(Long id) {
        //log.debug("Request to get animal by id=" + id);
        return repo.findById(id).get();
    }
}
