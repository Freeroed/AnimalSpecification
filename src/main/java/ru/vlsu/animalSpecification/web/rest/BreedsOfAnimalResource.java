package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(BreedsOfAnimalResource.class);

    @Autowired
    private BreedsOfAnimalService breedsService;

    @GetMapping("/breeds")
    public List<BreedsOfAnimal> getAllBreeds(){
        log.debug("REST request to get all breeds of animal");
        List<BreedsOfAnimal> list = breedsService.listAll();
        return list;
    }
}
