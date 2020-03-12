package ru.vlsu.animalSpecification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.TypeOfAnimal;
import ru.vlsu.animalSpecification.repository.TypeOfAnimalRepository;

import java.util.List;

@Service
@Transactional
public class TypeOfAnimalService {
    @Autowired
    private TypeOfAnimalRepository repo;

    public List<TypeOfAnimal> listAll() {
        return (List<TypeOfAnimal>) repo.findAll();
    }
}
