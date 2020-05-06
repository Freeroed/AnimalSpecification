package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.Document;
import ru.vlsu.animalSpecification.service.DocumentService;
import ru.vlsu.animalSpecification.service.impl.DocumentServiceImpl;


import java.io.IOException;

@RestController
@RequestMapping("/api")
public class DocumentResource {

  private static final Logger log = LoggerFactory.getLogger(DocumentResource.class);

  private final DocumentService documentService;


  @Autowired
  public DocumentResource(DocumentService documentService) {
    this.documentService = documentService;
  }

  @GetMapping("/document/new")
  public ResponseEntity createDocument() {
    log.debug("Rest request to create document");
    boolean result = documentService.createDocument();
    if (result) {
      return ResponseEntity.ok().body("Document created");
    } else {
      return ResponseEntity.badRequest().body("Creating file error");
    }
  }

  @GetMapping("/document/download")
  public ResponseEntity<InputStreamResource> downloadDocument() throws IOException {
    log.debug("Rest request to download document");
    FileSystemResource document = new FileSystemResource("D:\\Documents\\testDocument.pdf");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    //TODO Вынести это всё в сервис
    headers.setContentLength(document.contentLength());
    ResponseEntity<InputStreamResource> response = new ResponseEntity<>(new InputStreamResource(document.getInputStream()), headers, HttpStatus.OK);
    return response;
  }

  // Получить документ по id
  @GetMapping("/document/{id}")
  public ResponseEntity getDocument(@PathVariable Long id) {
    log.debug("REST request to get doc with id : {}", id);
    Document doc = documentService.get(id);
    if (doc != null) {
      return ResponseEntity.ok()
        .body(doc);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
