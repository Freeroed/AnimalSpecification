package ru.vlsu.animalSpecification.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.service.VaccineService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VaccineResource {
    @Autowired
    private VaccineService vaccineService;

    @GetMapping("/vaccines")
    public List<Vaccine> getAllVaccines() {
        return  vaccineService.listAll();
    }
}
