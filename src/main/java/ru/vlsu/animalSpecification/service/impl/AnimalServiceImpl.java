package ru.vlsu.animalSpecification.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.repository.AnimalRepository;
import ru.vlsu.animalSpecification.service.AnimalService;
import ru.vlsu.animalSpecification.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository repo;

    private final UserService userService;


  private static final Logger log =
    LoggerFactory.getLogger(AnimalServiceImpl.class);

  @Autowired
  public AnimalServiceImpl(AnimalRepository repo, UserService userService) {
    this.repo = repo;
    this.userService = userService;
  }

  public List<Animal> listAll() {
        log.debug("Request to get all animals");
        return (List<Animal>)repo.findAll();
    }

  @Override
  public List<Animal> findByUser(Long userId) {
    return repo.findAllByHuman(userId);
  }

  public Animal get(Long id) {
        log.debug("Request to get animal by id=" + id);
        return repo.findById(id).get();
    }

  @Override
  public Animal save(Animal animal, String username) {
    log.debug("Request to save animal : {} with human with username : {}" , animal.toString(), username);
    animal.setHuman(userService.findByUsername(username).getId());
    log.debug("Saving animal : " + animal);
    return repo.save(animal);
  }

  @Override
  public Page<Animal> findAll(Pageable pageable) {
    return null;
  }

  @Override
  public Optional<Animal> findOne(Long id) {
    log.debug("Request to find Animal by id : {}", id);
    return repo.findById(id);
  }

  @Override
  public void delete(Long id) {

  }
}
