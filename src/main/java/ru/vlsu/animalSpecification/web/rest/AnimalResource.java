package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.service.AnimalService;
import ru.vlsu.animalSpecification.service.dto.AnimalDTO;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class AnimalResource {

    private static final Logger log = LoggerFactory.getLogger(AnimalResource.class);
    private final AnimalService animalService;

    private final HttpServletRequest httpServletRequest;

    @Autowired
    public AnimalResource(AnimalService animalService, HttpServletRequest httpServletRequest) {
      this.animalService = animalService;
      this.httpServletRequest = httpServletRequest;
    }


  @GetMapping("/animals/my")
    public ResponseEntity getMyAnimals(){
      log.debug("REST request to get animals by user");
      String userName = httpServletRequest.getRemoteUser();
      List<AnimalDTO> result = animalService.findByUser(userName);
      return ResponseEntity.ok(result);
    }


  /**
   * {@code GET /animals} : get all animals
   * @return the {@link ResponseEntity} with status {@code 200(OK)} and the list of animals in body
   */
    @GetMapping("/animals")
    public ResponseEntity getAllAnimals(){
    log.debug("User that getted from servler request : {} ", httpServletRequest.getRemoteUser());
        log.debug("REST request to get all animals");
      List<AnimalDTO> result = animalService.listAll();
      return ResponseEntity.ok().body(result);
    }


  /**
   * {@code POST /animals} : Create a new Animal
   *
   * @param animal the animal to create
   * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body a new Animal? or with status {@code 400 (Bad Request} if the animal has already an ID
   * @throws URISyntaxException if the Location URI syntax is incorrect.
   */
    @PostMapping("/animals")
    public ResponseEntity createAnimal(@RequestBody Animal animal) throws URISyntaxException {
      //TODO Get user id from authorization
      log.debug("REST request to save animal : " + animal);

      if (animal.getId() != null) {
        return ResponseEntity.badRequest().build();
      } else {
        String userName = httpServletRequest.getRemoteUser();
        animal.setType(animal.getBreed().getAnimalType());
        AnimalDTO result = animalService.save(animal, userName);
        return ResponseEntity.created(new URI("/api/animals/" + result.getId()))
          .body(result);
      }
    }

  /**
   * {@code PUT /animals} : Updates an existing animal
   *
   * @param animal the animal to update
   * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated animal,
   * or with status {@code 400 (Bad Request)} if the todoDTO is not valid
   */
    @PutMapping("/animals")
    public ResponseEntity updateAnimal(@RequestBody Animal animal) {
      //TODO Get user id from authorization
      //TODO check user as animals's master
      //TODO check NotFound
      log.debug("REST request to update animal with name : {} ", animal.getNickname());

      if (animal.getId() == null) {
        return ResponseEntity.badRequest().build();
      }
      else {
        AnimalDTO result = animalService.save(animal, "admin");
        return ResponseEntity.ok()
          .body(result);
      }
    }

  /**
   * {@code GET /animals/:id} : get the "id" animal/
   *
   * @param id the id of the animal to retrieve
   * @return the {@link ResponseEntity} with statis {@code 200 (OK)} and with body the animal, or with status {@code 404 (Not Found)}
   */
    @GetMapping("/animals/{id}")
    public ResponseEntity getAnimal(@PathVariable Long id){
      log.debug("REST request to get animal with id : {}", id);
      Optional<AnimalDTO> animal = animalService.findOne(id);
      if (!animal.equals(Optional.empty())) {
        return ResponseEntity.ok()
          .body(animal);
      }
      else {
        return ResponseEntity.notFound().build();
      }

    }
    @DeleteMapping("/animals/{id}")
    public ResponseEntity deleteAnimal(@PathVariable Long id) {
      log.debug("REST request to delete animal with id : {}", id);
      animalService.delete(id);
      return ResponseEntity.noContent().build();
    }
}
