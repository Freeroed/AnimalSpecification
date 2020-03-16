package ru.vlsu.animalSpecification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.RosselkhoznadzorDivision;
import ru.vlsu.animalSpecification.repository.RosselkhoznadzorDivisionRepository;

import java.util.List;

@Service
@Transactional
public class RosselkhoznadzorDivisionService {
    @Autowired
    private RosselkhoznadzorDivisionRepository repo;

    public List<RosselkhoznadzorDivision> listAll() {
        return (List<RosselkhoznadzorDivision>) repo.findAll();
    }

    public RosselkhoznadzorDivision get(Long id) {
        return repo.findById(id).get();
    }

}
