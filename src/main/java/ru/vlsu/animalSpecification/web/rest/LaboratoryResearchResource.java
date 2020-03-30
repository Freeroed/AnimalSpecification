package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.service.LaboratoryResearchService;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LaboratoryResearchResource {

    private static final Logger log = LoggerFactory.getLogger(LaboratoryResearchResource.class);

    @Autowired
    private LaboratoryResearchService lrService;

    @GetMapping("/laboratoryResearchs")
    public List<LaboratoryResearch> getAllLaboratoryResearchs() {
        return  lrService.listAll();
    }

    // Создать результат лабораторного исследования
    @PostMapping("/laboratoryResearch")
    public ResponseEntity createLabResearch(@RequestBody LaboratoryResearch lr) throws URISyntaxException {

      log.debug("REST request to save laboratory research : " + lr);

      if ((lr.getId() != null)||(lr.getAnimal() == 0)) {
        return ResponseEntity.badRequest().build();
      } else {
        lrService.save(lr);
        return ResponseEntity.created(new URI("/laboratoryResearchs" ))
          .body(lr);
      }
    }

    // Обновить результат лабораторного иссладованич
    @PutMapping("/laboratoryResearch")
    public ResponseEntity updateLabResearch(@RequestBody LaboratoryResearch lr) {

      log.debug("REST request to update laboratory research with id : {} ", lr.getId());

      if (lr.getId() == null) {
        return ResponseEntity.badRequest().build();
      }
      else {
        lrService.save(lr);
        return ResponseEntity.ok().body(lr);
      }
    }

    // Удалить по id результат лабораторного исследования
    @DeleteMapping("/laboratoryResearch/{id}")
    public ResponseEntity deleteLabResearch(@PathVariable Long id) {
      log.debug("REST request to delete laboratory research with id : {}", id);
      lrService.delete(id);
      return ResponseEntity.noContent().build();
    }

    // Получить лабораторное исследование по id
    @GetMapping("/laboratoryResearch/{id}")
    public ResponseEntity getLabResearch(@PathVariable Long id) {
      log.debug("REST request to get laboratory research with id : {}", id);
      LaboratoryResearch lr = lrService.get(id);
      if (lr != null) {
        return ResponseEntity.ok()
          .body(lr);
      } else {
        return ResponseEntity.notFound().build();
      }
    }

    /* Получить все лабораторные исследования конкретного животного
       @param id - Id животного
    */
    @GetMapping("/laboratoryResearchByAnimal/{id}")
    public ResponseEntity getLabResearchByAnimal(@PathVariable Long id) {
      log.debug("REST request to get laboratory research by animal with id : {}", id);
      List <LaboratoryResearch> lr = lrService.getByAnimal(id);
      if (lr != null) {
        return ResponseEntity.ok()
          .body(lr);
      } else {
        return ResponseEntity.notFound().build();
      }
    }
}
