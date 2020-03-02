package ru.vlsu.animalSpecification.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.service.RequestService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestResource {
    @Autowired
    private RequestService requestService;

    @GetMapping("/requests")
    public List<Request> getAllRequests() {
        return  requestService.listAll();
    }
}
