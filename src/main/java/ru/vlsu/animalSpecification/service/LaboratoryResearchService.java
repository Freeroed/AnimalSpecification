package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.repository.LaboratoryResearchRepository;
import ru.vlsu.animalSpecification.service.dto.LaboratoryResearchDTO;
import ru.vlsu.animalSpecification.service.mapper.LaboratoryResearchMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LaboratoryResearchService {

    private static final Logger log = LoggerFactory.getLogger(LaboratoryResearchService.class);

    private final LaboratoryResearchRepository repo;

    private final LaboratoryResearchMapper laboratoryResearchMapper;


    @Autowired
    public LaboratoryResearchService(LaboratoryResearchRepository repo, LaboratoryResearchMapper laboratoryResearchMapper) {
      this.repo = repo;
      this.laboratoryResearchMapper = laboratoryResearchMapper;
    }

  public void save(LaboratoryResearch lr) {
        log.debug("Save laboratory research : {}", lr);
        repo.save(lr);
    }

    public List<LaboratoryResearchDTO> listAll() {
        return laboratoryResearchMapper.laboratoryResearchesToLaboratoryResearchesDTO((List<LaboratoryResearch>) repo.findAll());
    }

    public LaboratoryResearchDTO get(Long id) {
        log.debug("Find laboratory research by id : {}", id);
        LaboratoryResearchDTO res = null;
        try {
          res = laboratoryResearchMapper.laboratoryResearchToLaboratoryResearchDTO(repo.findById(id).get());
        } catch (Exception e){
            log.debug("Error finding laboratory research by id : {}", e.getMessage());
        }
        return res;
    }

    public void delete(Long id) {
        log.debug("Delete laboratory research : {} ", id);
        repo.deleteById(id);
    }

    public List <LaboratoryResearchDTO> getByAnimal(Long id) {
      log.debug("Find laboratory research by animal id: {} ", id);
      List <LaboratoryResearchDTO> res = new ArrayList<>();
      Animal animal = new Animal();
      animal.setId(id);
      try {
        res = laboratoryResearchMapper.laboratoryResearchesToLaboratoryResearchesDTO(repo.getAllByAnimal(animal));
      } catch (Exception e){
        log.debug("Error finding laboratory research by animal with id. Exc: {} ", e.getMessage());
      }
      return res;
    }

}
