package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.service.VaccineService;
import ru.vlsu.animalSpecification.service.dto.VaccineDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VaccineResource {

    private static final Logger log = LoggerFactory.getLogger(VaccineResource.class);

    private final VaccineService vaccineService;

    @Autowired
    public VaccineResource(VaccineService vaccineService) {
      this.vaccineService = vaccineService;
    }

  // Думаю, можно вообще удалить, но пока пусть будет для тестов
    @GetMapping("/vaccines")
    public ResponseEntity getAllVaccines(Long id) {
      if (id != null) {
        log.debug("REST request to get Vaccines by animal with id : {}", id);
        List<VaccineDTO> result = vaccineService.getByAnimal(id);
        return  ResponseEntity.ok(result);
      }
      log.debug("REST request to get all vaccines");
      List<Vaccine> result = vaccineService.listAll();
      return ResponseEntity.ok(result);
    }

    // Добавить запись о вакцинации
    @PostMapping("/vaccines")
    public ResponseEntity createVaccine(@RequestBody Vaccine vaccine) throws URISyntaxException {

      log.debug("REST request to save vaccine : {}", vaccine);

      if ((vaccine.getId() != null)||(vaccine.getAnimal() == null)) {
        return ResponseEntity.badRequest().build();
      } else {
        vaccineService.save(vaccine);
        return ResponseEntity.created(new URI("/vaccines" ))
          .body(vaccine);
      }
    }

    // Обновить запись о вакцинации
    @PutMapping("/vaccines")
    public ResponseEntity updateVaccine(@RequestBody Vaccine vaccine) {

      log.debug("REST request to update vaccine with id : {} ", vaccine.getId());

      if (vaccine.getId() == null) {
        return ResponseEntity.badRequest().build();
      }
      else {
        vaccineService.save(vaccine);
        return ResponseEntity.ok().body(vaccine);
      }
    }

    // Удалить по id запись о вакцинации
    @DeleteMapping("/vaccines/{id}")
    public ResponseEntity deleteVaccine(@PathVariable Long id) {
      log.debug("REST request to delete vaccine with id : {}", id);
      vaccineService.delete(id);
      return ResponseEntity.noContent().build();
    }

    // Получить запись о вакцинации по id
    @GetMapping("/vaccines/{id}")
    public ResponseEntity getVaccineById(@PathVariable Long id) {
      log.debug("REST request to get vaccine with id : {}", id);
      VaccineDTO res = vaccineService.get(id);
      if (res != null) {
        return ResponseEntity.ok()
          .body(res);
      } else {
        return ResponseEntity.notFound().build();
      }
    }

}
