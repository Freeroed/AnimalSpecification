package ru.vlsu.animalSpecification.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.BorderCrossingPoint;
import ru.vlsu.animalSpecification.repository.BorderCrossingPointRepository;

import java.util.List;

@Service
@Transactional
public class BorderCrossingPointService {
    @Autowired
    private BorderCrossingPointRepository repo;

    public List<BorderCrossingPoint> listAll() {
        return (List<BorderCrossingPoint>) repo.findAll();
    }
}
