package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.RosselkhoznadzorDivision;
import ru.vlsu.animalSpecification.repository.RosselkhoznadzorDivisionRepository;

import java.util.List;

@Service
@Transactional
public class RosselkhoznadzorDivisionService {

    private static final Logger log = LoggerFactory.getLogger(RosselkhoznadzorDivisionService.class);

    @Autowired
    private RosselkhoznadzorDivisionRepository repo;

    public List<RosselkhoznadzorDivision> listAll() {
        log.debug("Get all Rosselkhoznadzor Divisions");
        return (List<RosselkhoznadzorDivision>) repo.findAll();
    }

    public RosselkhoznadzorDivision get(Long id) {
        log.debug("Get Rosselkhoznadzor division by id: {}", id);
        return repo.findById(id).get();
    }

}
