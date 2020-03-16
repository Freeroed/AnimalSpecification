package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.LaboratoryTestResult;

public interface LaboratoryTestResultRepository extends CrudRepository<LaboratoryTestResult, Long> {
}
