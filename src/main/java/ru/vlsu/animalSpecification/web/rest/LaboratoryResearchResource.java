package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.service.LaboratoryResearchService;
import ru.vlsu.animalSpecification.service.dto.LaboratoryResearchDTO;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LaboratoryResearchResource {

    private static final Logger log = LoggerFactory.getLogger(LaboratoryResearchResource.class);


    private final LaboratoryResearchService laboratoryResearchService;

    @Autowired
    public LaboratoryResearchResource(LaboratoryResearchService lrService) {
      this.laboratoryResearchService = lrService;
    }

    @GetMapping("/laboratoryResearches")
    public ResponseEntity getAllLaboratoryResearchs(Long id) {
        if(id != null) {
          log.debug("REST request to get all LaboratoryResearches by Animal with id : {}", id);
          List<LaboratoryResearchDTO> result = laboratoryResearchService.getByAnimal(id);
          return ResponseEntity.ok(result);
        }
        log.debug("REST request to get all LaboratoryResearches");
        List<LaboratoryResearchDTO> result = laboratoryResearchService.listAll();
        return ResponseEntity.ok(result);
    }

    // Создать результат лабораторного исследования
    @PostMapping("/laboratoryResearches")
    public ResponseEntity createLabResearch(@RequestBody LaboratoryResearchDTO lr) throws URISyntaxException {

      log.debug("REST request to save laboratory research : {}", lr);

      if ((lr.getId() != null)||(lr.getAnimal() == null)) {
        return ResponseEntity.badRequest().build();
      } else {
        laboratoryResearchService.save(lr);
        return ResponseEntity.created(new URI("/laboratoryResearchs" ))
          .body(lr);
      }
    }

    // Обновить результат лабораторного иссладованич
    @PutMapping("/laboratoryResearches")
    public ResponseEntity updateLabResearch(@RequestBody LaboratoryResearchDTO lr) {

      log.debug("REST request to update laboratory research with id : {} ", lr.getId());

      if (lr.getId() == null) {
        return ResponseEntity.badRequest().build();
      }
      else {
        laboratoryResearchService.save(lr);
        return ResponseEntity.ok().body(lr);
      }
    }

    // Удалить по id результат лабораторного исследования
    @DeleteMapping("/laboratoryResearches/{id}")
    public ResponseEntity deleteLabResearch(@PathVariable Long id) {
      log.debug("REST request to delete laboratory research with id : {}", id);
      laboratoryResearchService.delete(id);
      return ResponseEntity.noContent().build();
    }

    // Получить лабораторное исследование по id
    @GetMapping("/laboratoryResearches/{id}")
    public ResponseEntity getLabResearch(@PathVariable Long id) {
      log.debug("REST request to get laboratory research with id : {}", id);
      LaboratoryResearchDTO lr = laboratoryResearchService.get(id);
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
      List <LaboratoryResearchDTO> lr = laboratoryResearchService.getByAnimal(id);
      if (lr != null) {
        return ResponseEntity.ok()
          .body(lr);
      } else {
        return ResponseEntity.notFound().build();
      }
    }
}
