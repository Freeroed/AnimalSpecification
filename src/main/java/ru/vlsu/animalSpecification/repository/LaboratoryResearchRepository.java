package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;

public interface LaboratoryResearchRepository extends CrudRepository<LaboratoryResearch, Long> {
}
