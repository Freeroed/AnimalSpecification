package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
