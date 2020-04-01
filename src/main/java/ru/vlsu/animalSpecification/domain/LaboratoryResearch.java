package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// Лабораторное исследование

@Entity
@Table(name = "Laboratory_research")
public class LaboratoryResearch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "laboratory")
    private String laboratory; // наименование лаборатории

    @Column (name = "indicator")
    private String indicator; // показатель

    @Column (name = "date_of_receipt_of_result")
    private Date dateOfReceiptOfResult; // день получения результата

    @Column (name = "research_method")
    private String researchMethod; // метод исследования

    @Column (name = "examination_number")
    private String examinationNumber; // номер экспертизы

    @Column (name = "result")
    private long result; // результат исследования	LaboratoryTestResult.class

    @Column (name = "animal")
    private long animal; // животное

    public LaboratoryResearch() { }

    /* Getters and Setters */

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

    public Date getDateOfReceiptOfResult() {
        return dateOfReceiptOfResult;
    }

    public void setDateOfReceiptOfResult(Date dateOfReceiptOfResult) {
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

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    public long getAnimal() {
        return animal;
    }

    public void setAnimal(long animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
      return "LaboratoryResearch{" +
        "id=" + id +
        ", laboratory='" + laboratory + '\'' +
        ", indicator='" + indicator + '\'' +
        ", dateOfReceiptOfResult=" + dateOfReceiptOfResult +
        ", researchMethod='" + researchMethod + '\'' +
        ", examinationNumber='" + examinationNumber + '\'' +
        ", result=" + result +
        ", animal=" + animal +
        '}';
    }
}
