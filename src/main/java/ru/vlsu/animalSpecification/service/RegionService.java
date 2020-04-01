package ru.vlsu.animalSpecification.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Region;
import ru.vlsu.animalSpecification.repository.RegionRepository;

@Service
@Transactional
public class RegionService {

    private static final Logger log = LoggerFactory.getLogger(RegionService.class);

    @Autowired
    private RegionRepository repo;

    public void save(Region region) {
        repo.save(region);
    }

    public List<Region> listAll() {
        log.debug("Get all regions");
        return (List<Region>) repo.findAll();
    }

    public Region get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Region> search(String keyword){ return repo.search(keyword); }

}
