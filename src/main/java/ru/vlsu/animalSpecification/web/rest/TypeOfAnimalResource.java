package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.TypeOfAnimal;
import ru.vlsu.animalSpecification.service.TypeOfAnimalService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfAnimalResource {

    private static final Logger log = LoggerFactory.getLogger(TypeOfAnimalResource.class);

    private final TypeOfAnimalService typeService;

    @Autowired
    public TypeOfAnimalResource(TypeOfAnimalService typeService) {
      this.typeService = typeService;
    }

    @GetMapping("/types")
    public List<TypeOfAnimal> getAllTypes() {
        log.debug("REST request to get all types of animals");
        List<TypeOfAnimal> list = typeService.listAll();
        return list;
    }

}
