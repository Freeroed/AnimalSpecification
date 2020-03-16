package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.DestinationCountry;

public interface DestinationCountryRepository extends CrudRepository<DestinationCountry, Long> {
}
