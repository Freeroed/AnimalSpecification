package ru.vlsu.animalSpecification.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.TypeOfAnimal;
import ru.vlsu.animalSpecification.service.TypeOfAnimalService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfAnimalResource {
    @Autowired
    private TypeOfAnimalService typeService;

    @GetMapping("/types")
    public List<TypeOfAnimal> getAllTypes() {
        List<TypeOfAnimal> list = typeService.listAll();
        return list;
    }
}
