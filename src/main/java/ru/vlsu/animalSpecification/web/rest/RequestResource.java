package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(RequestResource.class);

    @Autowired
    private RequestService requestService;

    // Можно удалить. Пока пусть будет для тестов
    @GetMapping("/requests")
    public List<Request> getAllRequests() {
        return  requestService.listAll();
    }
}
