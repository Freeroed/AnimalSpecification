package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.repository.VaccineRepository;

import java.util.List;

@Service
@Transactional
public class VaccineService {

    private static final Logger log = LoggerFactory.getLogger(Vaccine.class);

    @Autowired
    private VaccineRepository repo;

    public void save(Vaccine vac) {
        log.debug("Save vaccine: " + vac);
        repo.save(vac);
    }

    public List<Vaccine> listAll() {
        return (List<Vaccine>) repo.findAll();
    }

    public Vaccine get(Long id) {
        log.debug("Find vaccine by id: " + id);
      Vaccine res = null;
        try {
          res = repo.findById(id).get();
        } catch (Exception e){
          log.debug("Error finding vaccine by id: " + e);
        }
        return res;
    }

    public void delete(Long id) {
        log.debug("Delete vaccine with id: " + id);
        repo.deleteById(id);
    }

    public List <Vaccine> getByAnimal(Long id) {
      log.debug("Find laboratory research by animal id: " + id);
      List <Vaccine> res = null;
      try {
        res = repo.findAllByAnimal(id);
      } catch (Exception e){
        log.debug("Error finding vaccine by animal with id. Exc: " + e);
      }
      return res;
    }
}
