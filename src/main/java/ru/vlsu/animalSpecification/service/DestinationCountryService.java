package ru.vlsu.animalSpecification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.DestinationCountry;
import ru.vlsu.animalSpecification.repository.DestinationCountryRepository;

import java.util.List;

@Service
@Transactional
public class DestinationCountryService {
    @Autowired
    private DestinationCountryRepository repo;

    public void save(DestinationCountry country) {
        repo.save(country);
    }

    public List<DestinationCountry> listAll() {
        return (List<DestinationCountry>) repo.findAll();
    }

    public DestinationCountry get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
