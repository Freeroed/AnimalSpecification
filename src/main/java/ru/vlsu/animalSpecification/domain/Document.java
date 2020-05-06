package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "Document")
public class Document implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "type", nullable = false)
  private DocumentType type;  // тип документа (серт 1, серт 5а, евросправка)

  @Column (name = "date_of_issue")
  private Instant dateOfIssue; // дата выдачи документа

  @Column (name = "link")
  private String link; // ссылка на скачивание документа

  @Column (name = "document_number")
  private String documentNumber; // индивидуальный номер документа

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

  public Document() {
  }
}
