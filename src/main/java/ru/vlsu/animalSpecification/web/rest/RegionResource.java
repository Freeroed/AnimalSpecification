package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(RegionResource.class);


    private final RegionService regionService;

    @Autowired
    public RegionResource(RegionService regionService) {
      this.regionService = regionService;
    }

  @GetMapping("/regions")
    public List<Region> getAllRegions() {
      log.debug("REST request to get all regions");
      return  regionService.listAll();
    }

    /*@GetMapping("/search")
    List<Region> searchRegions() {
        return regionService.search("Евросоюз");
    }*/

}
