package ru.vlsu.animalSpecification.service.mapper;

import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.Document;
import ru.vlsu.animalSpecification.service.dto.DocumentDTO;

@Service
public class DocumentMapper {

  public DocumentDTO toDTO(Document document) {
    if (document == null) {
      return null;
    } else {
      DocumentDTO documentDTO = new DocumentDTO();
      documentDTO.setId(document.getId());
      documentDTO.setType(document.getType());
      documentDTO.setDateOfIssue(document.getDateOfIssue());
      documentDTO.setLink(document.getLink());
      documentDTO.setDocumentNumber(document.getDocumentNumber());
      return documentDTO;
    }
  }

  public Document toEntity(DocumentDTO documentDTO){
    if (documentDTO == null) {
      return null;
    } else {
      Document document = new Document();
      document.setId(documentDTO.getId());
      document.setType(documentDTO.getType());
      document.setDateOfIssue(documentDTO.getDateOfIssue());
      document.setLink(documentDTO.getLink());
      document.setDocumentNumber(documentDTO.getDocumentNumber());
      return document;
    }
  }

}
