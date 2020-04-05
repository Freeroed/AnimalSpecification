package ru.vlsu.animalSpecification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.DestinationCountry;
import ru.vlsu.animalSpecification.domain.Region;
import ru.vlsu.animalSpecification.domain.Vaccine;

import java.util.List;

public interface DestinationCountryRepository extends JpaRepository<DestinationCountry, Long> {
  List<DestinationCountry> findAllByRegion(Region region);
}
