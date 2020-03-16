package ru.vlsu.animalSpecification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.repository.LaboratoryResearchRepository;

import java.util.List;

@Service
@Transactional
public class LaboratoryResearchService {
    @Autowired
    private LaboratoryResearchRepository repo;

    public void save(LaboratoryResearch lr) {
        repo.save(lr);
    }

    public List<LaboratoryResearch> listAll() {
        return (List<LaboratoryResearch>) repo.findAll();
    }

    public LaboratoryResearch get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
