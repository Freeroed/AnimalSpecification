package ru.vlsu.animalSpecification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.domain.Vaccine;

import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
  List<Vaccine> findAllByAnimal(Animal animal);
}
