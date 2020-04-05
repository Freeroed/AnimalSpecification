package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.animalSpecification.domain.BreedsOfAnimal;
import ru.vlsu.animalSpecification.domain.TypeOfAnimal;
import ru.vlsu.animalSpecification.service.BreedsOfAnimalService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BreedsOfAnimalResource {

    private static final Logger log = LoggerFactory.getLogger(BreedsOfAnimalResource.class);


    private final BreedsOfAnimalService breedsService;

    @Autowired
    public BreedsOfAnimalResource(BreedsOfAnimalService breedsService) {
      this.breedsService = breedsService;
    }



    /* Получить породы для типа животного
       @param id - Id типа
    */
    @GetMapping("/breeds")
    public ResponseEntity getBreedsByAnimalType(Long id) {
      if (id != null) {
        log.debug("REST request to get breeds by animal type with id : {}", id);
        TypeOfAnimal typeOfAnimal = new TypeOfAnimal();
        typeOfAnimal.setId(id);
        List<BreedsOfAnimal> res = breedsService.getByType(typeOfAnimal);
        if (res != null) {
          return ResponseEntity.ok()
            .body(res);
        } else {
          return ResponseEntity.notFound().build();
        }
      }
      else {
        log.debug("REST request to get all Breeds of Animals");
        List<BreedsOfAnimal> animals = breedsService.listAll();
        return ResponseEntity.ok(animals);
      }
    }
}
