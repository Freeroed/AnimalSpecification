package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.Vaccine;

public interface VaccineRepository extends CrudRepository<Vaccine, Long> {
}
