package ru.vlsu.animalSpecification.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.vlsu.animalSpecification.domain.DocumentType;

import java.io.Serializable;
import java.time.Instant;

public class DocumentDTO implements Serializable {

  private Long id;

  private DocumentType type;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" ,timezone = "UTC")
  private Instant dateOfIssue;

  private String link;

  private String documentNumber;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DocumentType getType() {
    return type;
  }

  public void setType(DocumentType type) {
    this.type = type;
  }

  public Instant getDateOfIssue() {
    return dateOfIssue;
  }

  public void setDateOfIssue(Instant dateOfIssue) {
    this.dateOfIssue = dateOfIssue;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public DocumentDTO() {
  }

  @Override
  public String toString() {
    return "DocumentDTO{" +
      "id=" + id +
      ", type=" + type +
      ", dateOfIssue=" + dateOfIssue +
      ", link='" + link + '\'' +
      ", documentNumber='" + documentNumber + '\'' +
      '}';
  }
}
