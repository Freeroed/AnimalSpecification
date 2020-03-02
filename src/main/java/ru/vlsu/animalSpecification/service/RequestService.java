package ru.vlsu.animalSpecification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.repository.RequestRepository;

import java.util.List;

@Service
@Transactional
public class RequestService {
    @Autowired
    private RequestRepository repo;

    public void save(Request region) {
        repo.save(region);
    }

    public List<Request> listAll() {
        return (List<Request>) repo.findAll();
    }

    public Request get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}
