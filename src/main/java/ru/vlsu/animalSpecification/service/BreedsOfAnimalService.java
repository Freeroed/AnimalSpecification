package ru.vlsu.animalSpecification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.BreedsOfAnimal;
import ru.vlsu.animalSpecification.repository.BreedsOfAnimalRepository;

import java.util.List;

@Service
@Transactional
public class BreedsOfAnimalService {
    @Autowired
    private BreedsOfAnimalRepository repo;

    public List<BreedsOfAnimal> listAll() {
        return (List<BreedsOfAnimal>)repo.findAll();
    }
}
