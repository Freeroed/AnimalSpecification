package ru.vlsu.animalSpecification.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.BreedsOfAnimal;
import ru.vlsu.animalSpecification.service.BreedsOfAnimalService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BreedsOfAnimalResource {
    @Autowired
    private BreedsOfAnimalService breedsService;

    @GetMapping("/breeds")
    public List<BreedsOfAnimal> getAllBreeds(){
        List<BreedsOfAnimal> list = breedsService.listAll();
        return list;
    }
}
