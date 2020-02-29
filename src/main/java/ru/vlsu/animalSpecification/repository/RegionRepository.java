package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.Region;

public interface RegionRepository extends CrudRepository<Region, Long> {

}
