package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.Transport;

public interface TransportRepository extends CrudRepository<Transport, Long> {
}
