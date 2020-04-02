package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Transport;
import ru.vlsu.animalSpecification.repository.TransportRepository;

import java.util.List;

@Service
@Transactional
public class TransportService {

    private final TransportRepository repo;

    private static final Logger log = LoggerFactory.getLogger(TransportService.class);

    @Autowired
    public TransportService(TransportRepository repo) {
      this.repo = repo;
    }

  public List<Transport> listAll() {
        log.debug("Request to get All Transport");
        return (List<Transport>) repo.findAll();
    }
}
