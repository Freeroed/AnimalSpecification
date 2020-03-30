package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.service.VaccineService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VaccineResource {

    private static final Logger log = LoggerFactory.getLogger(VaccineResource.class);

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

    // Обновить запись о вакцинации
    @PutMapping("/vaccine")
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
    @DeleteMapping("/vaccine/{id}")
    public ResponseEntity deleteVaccine(@PathVariable Long id) {
      log.debug("REST request to delete vaccine with id : {}", id);
      vaccineService.delete(id);
      return ResponseEntity.noContent().build();
    }

    // Получить запись о вакцинации по id
    @GetMapping("/vaccine/{id}")
    public ResponseEntity getVaccineById(@PathVariable Long id) {
      log.debug("REST request to get vaccine with id : {}", id);
      Vaccine res = vaccineService.get(id);
      if (res != null) {
        return ResponseEntity.ok()
          .body(res);
      } else {
        return ResponseEntity.notFound().build();
      }
    }

    /* Получить все вакцинации конкретного животного
       @param id - Id животного
    */
    @GetMapping("/vaccineByAnimal/{id}")
    public ResponseEntity getVaccineByAnimalId(@PathVariable Long id) {
      log.debug("REST request to get vaccine by animal with id : {}", id);
      List <Vaccine> res = vaccineService.getByAnimal(id);
      if (res != null) {
        return ResponseEntity.ok()
          .body(res);
      } else {
        return ResponseEntity.notFound().build();
      }
    }
}
