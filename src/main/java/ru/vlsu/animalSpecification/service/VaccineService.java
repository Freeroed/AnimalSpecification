package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.repository.VaccineRepository;
import ru.vlsu.animalSpecification.service.dto.VaccineDTO;
import ru.vlsu.animalSpecification.service.mapper.VaccineMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VaccineService {

    private static final Logger log = LoggerFactory.getLogger(VaccineService.class);

    private final VaccineRepository repo;

    private final VaccineMapper vaccineMapper;

    @Autowired
    public VaccineService(VaccineRepository repo, VaccineMapper vaccineMapper) {
      this.repo = repo;
      this.vaccineMapper = vaccineMapper;
    }

  public void save(Vaccine vac) {
        log.debug("Save vaccine: {}", vac);
        repo.save(vac);
    }

    public List<Vaccine> listAll() {
        log.debug("Get all vaccines");
        return (List<Vaccine>) repo.findAll();
    }

    public VaccineDTO get(Long id) {
        log.debug("Find vaccine by id: {}", id);
      VaccineDTO res = null;
        try {
          res = vaccineMapper.vaccineToVaccineDTO(repo.findById(id).get());
        } catch (Exception e){
          log.debug("Error finding vaccine by id: {}", e.getMessage());
        }
        return res;
    }

    public void delete(Long id) {
        log.debug("Delete vaccine with id: {}", id);
        repo.deleteById(id);
    }

    public List <VaccineDTO> getByAnimal(Long id) {
      log.debug("Find vaccine by animal id: {}", id);
      List <VaccineDTO> res = new ArrayList<>();
      Animal animal = new Animal();
      animal.setId(id);
      try {
        res = vaccineMapper.vaccinesToVaccinesDTO(repo.findAllByAnimal(animal));
      } catch (Exception e){
        log.debug("Error finding vaccine by animal with id. Exc: {}", e.getMessage());
      }
      return res;
    }
}
