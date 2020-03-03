package ru.vlsu.animalSpecification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Transport;
import ru.vlsu.animalSpecification.repository.TransportRepository;

import java.util.List;

@Service
@Transactional
public class TransportService {
    @Autowired
    private TransportRepository repo;

    public List<Transport> listAll() {
        return (List<Transport>) repo.findAll();
    }
}
