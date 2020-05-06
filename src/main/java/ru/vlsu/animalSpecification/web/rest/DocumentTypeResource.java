package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.DocumentType;
import ru.vlsu.animalSpecification.service.DocumentTypeService;


import java.util.List;

@RestController
@RequestMapping("/api")
public class DocumentTypeResource {
  private static final Logger log = LoggerFactory.getLogger(RegionResource.class);

  private final DocumentTypeService docTypeService;

  @Autowired
  public DocumentTypeResource(DocumentTypeService dts) {
    this.docTypeService = dts;
  }

  @GetMapping("/documentTypes")
  public List<DocumentType> getAllDocsTypes() {
    log.debug("REST request to get all types of documents");
    return  docTypeService.listAll();
  }
}
