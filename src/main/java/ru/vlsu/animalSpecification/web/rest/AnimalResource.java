package ru.vlsu.animalSpecification.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.service.AnimalService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnimalResource {
    @Autowired
    private AnimalService animalService;

    @GetMapping("/animals/get")
    public String getAnimalName(){
        return "SOBAKEN";
    }

    @GetMapping("/animals")
    public List<Animal> getAllAnimals(){
        List<Animal> list = animalService.listAll();
        return list;
    }
}
