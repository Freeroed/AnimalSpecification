package ru.vlsu.animalSpecification.service;


import ru.vlsu.animalSpecification.domain.Document;
import ru.vlsu.animalSpecification.service.dto.DocumentDTO;

import java.util.Optional;

public interface DocumentService {

  boolean createDocument();

  Optional<DocumentDTO> get(Long id);

  DocumentDTO createFormOneCertificate(DocumentDTO documentDTO);
}
