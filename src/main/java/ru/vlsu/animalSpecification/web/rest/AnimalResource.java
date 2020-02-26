package ru.vlsu.animalSpecification.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AnimalResource {

    @GetMapping("/animals/get")
    public String getAnimalName(){
        return "SOBAKEN";
    }

    @GetMapping("/alimals")
    public List<String> getAllAnimals(){
        List<String> result = new ArrayList<>();
        result.add("cat one");
        result.add("cat two");
        return result;
    }
}
