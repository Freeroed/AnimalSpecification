package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.repository.LaboratoryResearchRepository;
import ru.vlsu.animalSpecification.web.rest.LaboratoryResearchResource;

import java.util.List;

@Service
@Transactional
public class LaboratoryResearchService {

    private static final Logger log = LoggerFactory.getLogger(LaboratoryResearchService.class);

    @Autowired
    private LaboratoryResearchRepository repo;

    public void save(LaboratoryResearch lr) {
        log.debug("Save laboratory research : " + lr);
        repo.save(lr);
    }

    public List<LaboratoryResearch> listAll() {
        return (List<LaboratoryResearch>) repo.findAll();
    }

    public LaboratoryResearch get(Long id) {
        log.debug("Find laboratory research by id: " + id);
        LaboratoryResearch res = null;
        try {
          res = repo.findById(id).get();
        } catch (Exception e){
            log.debug("Error finding laboratory research by id: " + e);
        }
        return res;
    }

    public void delete(Long id) {
        log.debug("Delete laboratory research : " + id);
        repo.deleteById(id);
    }

    public List <LaboratoryResearch> getByAnimal(Long id) {
      log.debug("Find laboratory research by animal id: " + id);
      List <LaboratoryResearch> res = null;
      try {
        res = repo.getAllByAnimal(id);
      } catch (Exception e){
        log.debug("Error finding laboratory research by animal with id. Exc: : " + e);
      }
      return res;
    }

}
