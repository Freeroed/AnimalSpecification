package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.DocumentType;

public interface DocumentTypeRepository extends CrudRepository<DocumentType, Long> {

  DocumentType findByName(String name);
}
