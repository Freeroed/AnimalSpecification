package ru.vlsu.animalSpecification.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.domain.Vaccine;

import java.util.List;

public interface VaccineRepository extends CrudRepository<Vaccine, Long> {
  @Query(value = "SELECT c from Vaccine c WHERE c.animal LIKE :id ")
  List<Vaccine> getByAnimal(@Param("id") long id);
}
