package ru.vlsu.animalSpecification.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.DAO.RegionDAO;
import ru.vlsu.animalSpecification.domain.Region;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RegionController {

    @GetMapping("/regions")
    public List<Region> getAllRegions(){
        RegionDAO dao = new RegionDAO();
        List<Region> result = dao.findAll();
        return result;
    }
}
