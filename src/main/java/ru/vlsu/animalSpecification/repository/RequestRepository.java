package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.Request;

public interface RequestRepository extends CrudRepository<Request, Long> {

}
