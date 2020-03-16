package ru.vlsu.animalSpecification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.LaboratoryTestResult;
import ru.vlsu.animalSpecification.repository.LaboratoryTestResultRepository;

import java.util.List;

@Service
@Transactional
public class LaboratoryTestResultService {
    @Autowired
    private LaboratoryTestResultRepository repo;

    public List<LaboratoryTestResult> listAll() {
        return (List<LaboratoryTestResult>) repo.findAll();
    }

    public LaboratoryTestResult get(Long id) {
        return repo.findById(id).get();
    }


}
