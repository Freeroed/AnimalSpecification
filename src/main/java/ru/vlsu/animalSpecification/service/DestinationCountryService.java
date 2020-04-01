package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.DestinationCountry;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.repository.DestinationCountryRepository;

import java.util.List;

@Service
@Transactional
public class DestinationCountryService {

    private static final Logger log = LoggerFactory.getLogger(DestinationCountryService.class);

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

    public List <DestinationCountry> getByRegion(Long id) {
      log.debug("Find countrys by region id: " + id);
      List <DestinationCountry> res = null;
      try {
        res = repo.findAllByRegion(id);
      } catch (Exception e){
        log.debug("Error finding countrys by region with id. Exc: " + e.getMessage());
      }
      return res;
    }
}
