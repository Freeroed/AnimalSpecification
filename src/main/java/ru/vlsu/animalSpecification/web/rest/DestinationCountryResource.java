package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.animalSpecification.domain.DestinationCountry;
import ru.vlsu.animalSpecification.domain.Region;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.service.DestinationCountryService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DestinationCountryResource {

    private static final Logger log = LoggerFactory.getLogger(Vaccine.class);

    private final DestinationCountryService dcService;

    @Autowired
    public DestinationCountryResource(DestinationCountryService dcService) {
      this.dcService = dcService;
    }

  // Можно удалить (скорее всего не будет использоваться)
    @GetMapping("/countries")
    public ResponseEntity getAllCountries(Long id) {
      if (id != null) {
        log.debug("REST request to get Countries by region with id: {}", id);
        Region region = new Region();
        region.setId(id);
        List<DestinationCountry> result = dcService.getByRegion(region);
        return ResponseEntity.ok(result);
      }
        log.debug("REST request to get all countries");
        return  ResponseEntity.ok(dcService.listAll());
    }

}
