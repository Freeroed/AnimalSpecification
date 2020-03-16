package ru.vlsu.animalSpecification.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.LaboratoryTestResult;
import ru.vlsu.animalSpecification.service.LaboratoryTestResultService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LaboratoryTestResultResource {
    @Autowired
    private LaboratoryTestResultService ltrService;

    @GetMapping("/testResults")
    public List<LaboratoryTestResult> getAllTestResults() {
        return  ltrService.listAll();
    }

}
