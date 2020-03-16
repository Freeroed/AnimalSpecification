package ru.vlsu.animalSpecification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.repository.VaccineRepository;

import java.util.List;

@Service
@Transactional
public class VaccineService {
    @Autowired
    private VaccineRepository repo;

    public void save(Vaccine vac) {
        repo.save(vac);
    }

    public List<Vaccine> listAll() {
        return (List<Vaccine>) repo.findAll();
    }

    public Vaccine get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
