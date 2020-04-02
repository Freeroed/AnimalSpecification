package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.BorderCrossingPoint;
import ru.vlsu.animalSpecification.repository.BorderCrossingPointRepository;

import java.util.List;

@Service
@Transactional
public class BorderCrossingPointService {

    private static final Logger log = LoggerFactory.getLogger(BorderCrossingPointService.class);

    private final BorderCrossingPointRepository repo;

    @Autowired
    public BorderCrossingPointService(BorderCrossingPointRepository repo) {
      this.repo = repo;
    }

  public List<BorderCrossingPoint> listAll() {
        log.debug("Get all border crossing points");
        return (List<BorderCrossingPoint>) repo.findAll();
    }
}
