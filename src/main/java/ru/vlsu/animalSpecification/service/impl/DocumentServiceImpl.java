package ru.vlsu.animalSpecification.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.DocumentType;
import ru.vlsu.animalSpecification.repository.DocumentRepository;
import ru.vlsu.animalSpecification.service.DocumentService;
import ru.vlsu.animalSpecification.service.dto.DocumentDTO;
import ru.vlsu.animalSpecification.service.mapper.DocumentMapper;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

  private static final Logger log = LoggerFactory.getLogger(DocumentService.class);
  private final DocumentRepository repo;
  private final DocumentMapper documentMapper;

  @Autowired
  public DocumentServiceImpl(DocumentRepository repo, DocumentMapper documentMapper) {
    this.repo = repo;
    this.documentMapper = documentMapper;
  }

  @Override
  public boolean createDocument() {
    Document document = new Document();
    try {
      PdfWriter.getInstance(document, new FileOutputStream("D:\\Documents\\testDocument.pdf"));
      document.open();
      Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
      Chunk chunk = new Chunk("NEw Test request", font);
      document.add(chunk);
      document.close();
      return true;
    } catch (FileNotFoundException | DocumentException e) {
        log.error("Error in creating pdf file : {}", e.getMessage());
        return false;
    }
  }

  @Override
  public Optional<DocumentDTO> get(Long id) {
    log.debug("get documents by id");
    return repo.findById(id).map(documentMapper::toDTO);
  }

  @Override
  public DocumentDTO createFormOneCertificate(DocumentDTO documentDTO) {
    log.debug("request to create form one certificate");
    ru.vlsu.animalSpecification.domain.Document document = documentMapper.toEntity(documentDTO);
    document.setDateOfIssue(Instant.now());
    document.setLink("temp link");
    DocumentType documentType = new DocumentType();
    documentType.setId(2L);
    document.setType(documentType);
    document = repo.save(document);
    return documentMapper.toDTO(document);
  }
}
