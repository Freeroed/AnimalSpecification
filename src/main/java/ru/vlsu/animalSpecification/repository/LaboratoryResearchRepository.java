package ru.vlsu.animalSpecification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.domain.Region;

import java.util.List;

public interface LaboratoryResearchRepository extends JpaRepository<LaboratoryResearch, Long> {

  List<LaboratoryResearch> getAllByAnimal(Animal animal);
}
