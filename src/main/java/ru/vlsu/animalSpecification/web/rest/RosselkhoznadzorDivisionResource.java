package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.RosselkhoznadzorDivision;
import ru.vlsu.animalSpecification.service.RosselkhoznadzorDivisionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RosselkhoznadzorDivisionResource {

    private static final Logger log = LoggerFactory.getLogger(RosselkhoznadzorDivisionResource.class);

    @Autowired
    private RosselkhoznadzorDivisionService rshService;

    @GetMapping("/divisionsRsh")
    public List<RosselkhoznadzorDivision> getAllDivisionsRsh() {
        log.debug("REST request to get all Rosselkhoznadzor Divisions");
        return  rshService.listAll();
    }
}
