package ru.vlsu.animalSpecification.web.rest;

import org.apache.log4j.Logger;
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

    private static final Logger log = Logger.getLogger(TransportResource.class);

    @GetMapping("/transports")
    public List<Transport> getAll() {
        List<Transport> list = transportService.listAll();
        // Этот логер выкидывает 500 ошибку
        //log.debug("Request go get All Transport: {}", (Throwable) list);
        return list;
    }
}
