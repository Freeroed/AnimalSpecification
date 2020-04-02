package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(LaboratoryTestResultResource.class);


    private final LaboratoryTestResultService ltrService;

    @Autowired
    public LaboratoryTestResultResource(LaboratoryTestResultService ltrService) {
      this.ltrService = ltrService;
    }

  @GetMapping("/testResults")
    public List<LaboratoryTestResult> getAllTestResults() {
        log.debug("REST request to get all lab test results");
        return  ltrService.listAll();
    }

}
