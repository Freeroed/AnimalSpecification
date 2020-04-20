package ru.vlsu.animalSpecification.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.domain.emun.LaboratoryTestResult;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

public class LaboratoryResearchDTO implements Serializable {

  private Long id;

  private String laboratory;

  private String indicator;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" ,timezone = "UTC")
  private Instant dateOfReceiptOfResult;

  private String researchMethod;

  private String examinationNumber;

  private LaboratoryTestResult result;

  private AnimalDTO animal;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLaboratory() {
    return laboratory;
  }

  public void setLaboratory(String laboratory) {
    this.laboratory = laboratory;
  }

  public String getIndicator() {
    return indicator;
  }

  public void setIndicator(String indicator) {
    this.indicator = indicator;
  }

  public Instant getDateOfReceiptOfResult() {
    return dateOfReceiptOfResult;
  }

  public void setDateOfReceiptOfResult(Instant dateOfReceiptOfResult) {
    this.dateOfReceiptOfResult = dateOfReceiptOfResult;
  }

  public String getResearchMethod() {
    return researchMethod;
  }

  public void setResearchMethod(String researchMethod) {
    this.researchMethod = researchMethod;
  }

  public String getExaminationNumber() {
    return examinationNumber;
  }

  public void setExaminationNumber(String examinationNumber) {
    this.examinationNumber = examinationNumber;
  }

  public LaboratoryTestResult getResult() {
    return result;
  }

  public void setResult(LaboratoryTestResult result) {
    this.result = result;
  }

  public AnimalDTO getAnimal() {
    return animal;
  }

  public void setAnimal(AnimalDTO animal) {
    this.animal = animal;
  }

  public LaboratoryResearchDTO() {
  }

  public LaboratoryResearchDTO(LaboratoryResearch laboratoryResearch) {
    this.id = laboratoryResearch.getId();
    this.laboratory = laboratoryResearch.getLaboratory();
    this.indicator = laboratoryResearch.getIndicator();
    this.dateOfReceiptOfResult = laboratoryResearch.getDateOfReceiptOfResult();
    this.researchMethod = laboratoryResearch.getResearchMethod();
    this.examinationNumber = laboratoryResearch.getExaminationNumber();
    this.result = laboratoryResearch.getResult();
    this.animal = new AnimalDTO(laboratoryResearch.getAnimal());
  }
}
