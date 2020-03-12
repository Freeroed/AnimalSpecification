package ru.vlsu.animalSpecification.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.BorderCrossingPoint;
import ru.vlsu.animalSpecification.service.BorderCrossingPointService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BorderCrossingPointResouce {
    @Autowired
    private BorderCrossingPointService bcpService;

    @GetMapping("/borderCrossingPoints")
    public List<BorderCrossingPoint> getAllBorderCrossingPoints(){
        List<BorderCrossingPoint> list = bcpService.listAll();
        return list;
    }
}
