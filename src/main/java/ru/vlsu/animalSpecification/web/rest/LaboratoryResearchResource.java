package ru.vlsu.animalSpecification.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.domain.Region;
import ru.vlsu.animalSpecification.service.LaboratoryResearchService;
import ru.vlsu.animalSpecification.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LaboratoryResearchResource {

    @Autowired
    private LaboratoryResearchService lrService;

    @GetMapping("/laboratoryResearchs")
    public List<LaboratoryResearch> getAllLaboratoryResearchs() {
        return  lrService.listAll();
    }
}
