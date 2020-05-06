package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.DocumentType;
import ru.vlsu.animalSpecification.repository.DocumentTypeRepository;

import java.util.List;

@Service
@Transactional
public class DocumentTypeService {
  private static final Logger log = LoggerFactory.getLogger(DocumentTypeService.class);

  private final DocumentTypeRepository repo;

  @Autowired
  public DocumentTypeService(DocumentTypeRepository repo) {
    this.repo = repo;
  }


  public List<DocumentType> listAll() {
    log.debug("Get all types of documents");
    return (List<DocumentType>) repo.findAll();
  }

}
