package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.repository.RequestRepository;

import java.util.List;

@Service
@Transactional
public class RequestService {

    private static final Logger log = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    private RequestRepository repo;

    public void save(Request req) {
        log.debug("Save request: {}", req);
        repo.save(req);
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
