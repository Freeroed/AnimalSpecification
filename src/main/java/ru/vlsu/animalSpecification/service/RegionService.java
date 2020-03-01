package ru.vlsu.animalSpecification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Region;
import ru.vlsu.animalSpecification.repository.RegionRepository;

@Service
@Transactional
public class RegionService {
    @Autowired
    private RegionRepository repo;

    public void save(Region region) {
        repo.save(region);
    }

    public List<Region> listAll() {
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