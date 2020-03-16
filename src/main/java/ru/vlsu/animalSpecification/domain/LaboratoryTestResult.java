package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;

// Результат лабораторного исследования

@Entity
@Table(name = "Laboratory_test_result")
public class LaboratoryTestResult implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "result_name")
    private String resultName;

    @Column (name = "result_name_ENG")
    private String resultNameENG;

    public LaboratoryTestResult() {}

    /* Getters and Setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public String getResultNameENG() {
        return resultNameENG;
    }

    public void setResultNameENG(String resultNameENG) {
        this.resultNameENG = resultNameENG;
    }
}
