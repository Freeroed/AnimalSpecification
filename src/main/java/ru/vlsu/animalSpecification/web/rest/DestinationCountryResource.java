package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.DestinationCountry;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.service.DestinationCountryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DestinationCountryResource {

    private static final Logger log = LoggerFactory.getLogger(Vaccine.class);

    @Autowired
    private DestinationCountryService dcService;

    // Можно удалить (скорее всего не будет использоваться)
    @GetMapping("/countries")
    public List<DestinationCountry> getAllCountries() {
        log.debug("REST request to get all countries");
        return  dcService.listAll();
    }

    /* Получить все страны региона
       @param id - Id региона
    */
    @GetMapping("/countries/{id}")
    public ResponseEntity getVaccineByRegionId(@PathVariable Long id) {
      log.debug("REST request to get countries by region with id : {}", id);
      List <DestinationCountry> res = dcService.getByRegion(id);
      if (res != null) {
        return ResponseEntity.ok()
          .body(res);
      } else {
        return ResponseEntity.notFound().build();
      }
    }
}
