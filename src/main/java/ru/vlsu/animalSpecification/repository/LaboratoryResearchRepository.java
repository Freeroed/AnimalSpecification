package ru.vlsu.animalSpecification.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.domain.Region;

import java.util.List;

public interface LaboratoryResearchRepository extends CrudRepository<LaboratoryResearch, Long> {
  @Query(value = "SELECT c from LaboratoryResearch c WHERE c.animal LIKE :id ")
  List<LaboratoryResearch> getByAnimal(@Param("id") long id);
}
