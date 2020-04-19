package ru.vlsu.animalSpecification.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.domain.emun.AnimalStatus;
import ru.vlsu.animalSpecification.repository.AnimalRepository;
import ru.vlsu.animalSpecification.service.AnimalService;
import ru.vlsu.animalSpecification.service.UserService;
import ru.vlsu.animalSpecification.service.dto.AnimalDTO;
import ru.vlsu.animalSpecification.service.mapper.AnimalMapper;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository repo;

    private final UserService userService;

    private final AnimalMapper animalMapper;

    private static final Logger log =
      LoggerFactory.getLogger(AnimalServiceImpl.class);

    @Autowired
    public AnimalServiceImpl(AnimalRepository repo, UserService userService, AnimalMapper animalMapper) {
      this.repo = repo;
      this.userService = userService;
      this.animalMapper = animalMapper;
    }

    public List<AnimalDTO> listAll() {
          log.debug("Request to get all animals");
          return animalMapper.animalsToAnimalsDTO(repo.findAll());
      }

    @Override
    public List<AnimalDTO> findByUser(String userName) {
      log.debug("Request to get all animals by user with userName : {}", userName);
      User user = userService.findByUsername(userName);
      List<Animal> animals = repo.findAllByMaster(user);
      List<AnimalDTO> result = animalMapper.animalsToAnimalsDTO(animals);
      return result;
    }

    public Animal get(Long id) {
          log.debug("Request to get animal by id=" + id);
          return repo.findById(id).get();
      }

    @Override
    public AnimalDTO save(Animal animal, String username) {
      log.debug("Request to save animal : {} with human with username : {}" , animal.toString(), username);
      if (animal.getId() == null) {
        animal.setMaster(userService.findByUsername(username));
        animal.setStatus(AnimalStatus.READY_TO_REQUEST);
      } else {
        User master = new User();
        master.setId(findOne(animal.getId()).get().getMaster().getId());
        animal.setMaster(master);
      }
      log.debug("Saving animal : " + animal);
      return new AnimalDTO(repo.save(animal));
    }

    @Override
    public Page<AnimalDTO> findAll(Pageable pageable) {
      return null;
    }

    @Override
    public Optional<AnimalDTO> findOne(Long id) {
      log.debug("Request to find Animal by id : {}", id);
      return repo.findById(id).map(animalMapper::animalToAnimalsDTO);
    }

    @Override
    public void delete(Long id) {
      log.debug("Request to delete animal with : {}", id);
      repo.deleteById(id);
    }
}
