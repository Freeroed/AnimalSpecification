package ru.vlsu.animalSpecification.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Transport;
import ru.vlsu.animalSpecification.repository.TransportRepository;
import ru.vlsu.animalSpecification.web.controller.HomeController;

import java.util.List;

@Service
@Transactional
public class TransportService {
    @Autowired
    private TransportRepository repo;
    private static final Logger log = Logger.getLogger(TransportService.class);

    public List<Transport> listAll() {
        log.debug("Request to get All Transport");
        return (List<Transport>) repo.findAll();
    }
}
