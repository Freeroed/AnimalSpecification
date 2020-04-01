package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.LaboratoryTestResult;
import ru.vlsu.animalSpecification.repository.LaboratoryTestResultRepository;

import java.util.List;

@Service
@Transactional
public class LaboratoryTestResultService {

    private static final Logger log = LoggerFactory.getLogger(VaccineService.class);

    @Autowired
    private LaboratoryTestResultRepository repo;

    public List<LaboratoryTestResult> listAll() {
        log.debug("Get all lab test results");
        return (List<LaboratoryTestResult>) repo.findAll();
    }

    public LaboratoryTestResult get(Long id) {
        return repo.findById(id).get();
    }


}
