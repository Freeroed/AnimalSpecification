package ru.vlsu.animalSpecification.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.Region;
import ru.vlsu.animalSpecification.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegionResource {

    @Autowired
    private RegionService regionService;

    @GetMapping("/regions")
    public List<Region> getAllRegions() {
        return  regionService.listAll();
    }

    /*@GetMapping("/search")
    List<Region> searchRegions() {
        return regionService.search("Евросоюз");
    }*/

}
