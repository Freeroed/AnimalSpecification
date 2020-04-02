package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(BorderCrossingPointResouce.class);

    private final BorderCrossingPointService bcpService;

    @Autowired
    public BorderCrossingPointResouce(BorderCrossingPointService bcpService) {
      this.bcpService = bcpService;
    }

  @GetMapping("/borderCrossingPoints")
    public List<BorderCrossingPoint> getAllBorderCrossingPoints(){
        log.debug("REST request to get all border crossing points");
        List<BorderCrossingPoint> list = bcpService.listAll();
        return list;
    }
}
