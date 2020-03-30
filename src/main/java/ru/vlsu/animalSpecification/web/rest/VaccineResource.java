package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.service.VaccineService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VaccineResource {

    private static final Logger log = LoggerFactory.getLogger(Vaccine.class);

    @Autowired
    private VaccineService vaccineService;

    // Думаю, можно вообще удалить, но пока пусть будет для тестов
    @GetMapping("/vaccines")
    public List<Vaccine> getAllVaccines() {
        return  vaccineService.listAll();
    }

    // Добавить запись о вакцинации
    @PostMapping("/vaccine")
    public ResponseEntity createVaccine(@RequestBody Vaccine vaccine) throws URISyntaxException {

      log.debug("REST request to save vaccine : " + vaccine);

      if ((vaccine.getId() != null)||(vaccine.getAnimal() == 0)) {
        return ResponseEntity.badRequest().build();
      } else {
        vaccineService.save(vaccine);
        return ResponseEntity.created(new URI("/vaccines" ))
          .body(vaccine);
      }
    }
}
