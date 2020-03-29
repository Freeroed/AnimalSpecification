package ru.vlsu.animalSpecification.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.DestinationCountry;
import ru.vlsu.animalSpecification.service.DestinationCountryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DestinationCountryResource {
    @Autowired
    private DestinationCountryService dcService;

    @GetMapping("/countries")
    public List<DestinationCountry> getAllCountries() {
        return  dcService.listAll();
    }
}
