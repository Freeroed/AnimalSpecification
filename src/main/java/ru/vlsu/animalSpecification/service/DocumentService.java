package ru.vlsu.animalSpecification.service;


import ru.vlsu.animalSpecification.domain.Document;
import ru.vlsu.animalSpecification.service.dto.DocumentDTO;
import ru.vlsu.animalSpecification.service.dto.RequestDTO;

import java.io.IOException;
import java.util.Optional;

public interface DocumentService {

  boolean createDocument();

  Optional<DocumentDTO> get(Long id);

  DocumentDTO createFormOneCertificate(DocumentDTO documentDTO);

  DocumentDTO createDocumentFromRequest(RequestDTO requestDTO, String documentType) throws IOException;

}
