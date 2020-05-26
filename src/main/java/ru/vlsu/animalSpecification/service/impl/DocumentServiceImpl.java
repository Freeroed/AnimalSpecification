package ru.vlsu.animalSpecification.service.impl;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.DocumentType;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.repository.DocumentRepository;
import ru.vlsu.animalSpecification.repository.DocumentTypeRepository;
import ru.vlsu.animalSpecification.service.DocumentService;
import ru.vlsu.animalSpecification.service.dto.DocumentDTO;
import ru.vlsu.animalSpecification.service.dto.RequestDTO;
import ru.vlsu.animalSpecification.service.mapper.DocumentMapper;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

  private static final Logger log = LoggerFactory.getLogger(DocumentService.class);
  private final DocumentRepository repo;
  private final DocumentMapper documentMapper;

  private final DocumentTypeRepository documentTypeRepository;

  private final DocumentRepository documentRepository;
  private final String FORM_FIVE_CERTIFICATE_TEMPLATE = "D:\\Documents\\templates\\FORM_FIVE_CERTIFICATE_TEMPLATE.jpg";

  @Autowired
  public DocumentServiceImpl(DocumentRepository repo, DocumentMapper documentMapper, DocumentTypeRepository documentTypeRepository, DocumentRepository documentRepository) {
    this.repo = repo;
    this.documentMapper = documentMapper;
    this.documentTypeRepository = documentTypeRepository;
    this.documentRepository = documentRepository;
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

  @Override
  public DocumentDTO createDocumentFromRequest(Request request, String documentType) throws IOException {
    ru.vlsu.animalSpecification.domain.Document document = new ru.vlsu.animalSpecification.domain.Document();
    document.setType(documentTypeRepository.findByName(documentType));
    document.setDateOfIssue(Instant.now());
    document.setLink(" ");
    document.setDocumentNumber(" ");
    document = documentRepository.save(document);
    document.setDocumentNumber(document.getId()+"");
    document.setLink("api/documents/" + document.getId() + "/download");
    Document doc = new Document(PageSize.A4);
    File file = new File("D:\\Documents\\" + document.getId() + ".pdf");
    if (file.createNewFile())
     {
       try {
          PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("D:\\Documents\\" + document.getId() + ".pdf"));
          doc.open();
         Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13, BaseColor.BLACK);
          if (documentType == "Ветеринарный сертификат формы 5а") {
            PdfContentByte canvas = writer.getDirectContentUnder();
            Image image = Image.getInstance(FORM_FIVE_CERTIFICATE_TEMPLATE);
            image.scaleAbsolute(PageSize.A4);
            image.setAbsolutePosition(0, 0);
            canvas.saveState();
            PdfGState state = new PdfGState();
            state.setFillOpacity(0.6f);
            canvas.setGState(state);
            canvas.addImage(image);
            canvas.restoreState();
            ColumnText ct = new ColumnText(canvas);
            ct.setSimpleColumn(300f, 150f, 200f,485f);
            Paragraph ph = new Paragraph(request.getAnimals().size() + " animals", font);
            ct.addElement(ph);
            ct.go();
            int countAnimals = 0;
            for (Animal animal: request.getAnimals()) {
              DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                .withZone(ZoneId.systemDefault());
              ct.setSimpleColumn(100f, 150f, 150f,400f - 35*countAnimals);
              ph = new Paragraph(animal.getBreed().getAnimalType().getTypeNameENG(), font);
              ct.addElement(ph);
              ct.go();
              ct.setSimpleColumn(240f, 150f, 350f,400f - 35*countAnimals);
              ph = new Paragraph("w".equals(animal.getSex()) ? "w" : "f", font);
              ct.addElement(ph);
              ct.go();
              ct.setSimpleColumn(270f, 150f, 400f,400f - 35*countAnimals);
              ph = new Paragraph(animal.getBreed().getBreedNameENG(), font);
              ct.addElement(ph);
              ct.go();ct.setSimpleColumn(320f, 150f, 370f,400f - 35*countAnimals);
              ph = new Paragraph(formater.format(animal.getBirthday()), font);
              ct.addElement(ph);
              ct.go();
              ct.setSimpleColumn(370f, 150f, 500f,400f - 35*countAnimals);
              ph = new Paragraph("Chip - " +animal.getChip(), font);
              ct.addElement(ph);
              ct.go();
              countAnimals++;
            }
            ct.setSimpleColumn(260f, 150f, 560f,540f);
            ph = new Paragraph(request.getInspectorOfRosselkhoznadzor().getRosselkhoznadzorDivision().getNameENG(), font);
            ct.addElement(ph);
            ct.go();
            ct.setSimpleColumn(260f, 95f, 560f,60f);
            ph = new Paragraph(request.getRecipient().getSurnameEng() + " " + request.getRecipient().getNameEng(), font);
            ct.addElement(ph);
            ct.go();
          }
          Chunk chunk = new Chunk(document.getDocumentNumber(), font);
          doc.add(chunk);
          doc.close();

        } catch (FileNotFoundException | DocumentException e) {
          log.error("Error in creating pdf file : {}", e.getMessage());
        }
     }
    document.setLink("api/documents/" + document.getId() + "/download");
    document = documentRepository.save(document);
    return documentMapper.toDTO(document);
  }
}
