package ru.vlsu.animalSpecification.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.service.DocumentService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

  private static final Logger log = LoggerFactory.getLogger(DocumentService.class);
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
}
