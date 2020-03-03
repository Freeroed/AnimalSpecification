package ru.vlsu.animalSpecification.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.Transport;
import ru.vlsu.animalSpecification.service.TransportService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransportResource {
    @Autowired
    private TransportService transportService;

    @GetMapping("/transports")
    public List<Transport> getAllRequests() {
        return  transportService.listAll();
    }
}
