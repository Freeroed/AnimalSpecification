package ru.vlsu.animalSpecification.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.vlsu.animalSpecification.domain.emun.VaccineType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

// Сведение о вакцинации

@Entity
@Table(name = "Vaccine")
public class Vaccine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal", nullable = false)
    private Animal animal; // животное

    @Enumerated(EnumType.STRING)
    @Column (name = "type")
    private VaccineType type; // тип вакцины

    @Column (name = "title")
    private String title; // наименование

    @Column (name = "date")
    private Instant date; // дата проведения

    @Column (name = "vaccine_batch_number")
    private String vaccineBatchNumber; // номер серии вакцины

    @Column (name = "vaccine_name_and_manufacturer")
    private String vaccineNameAndManufacturer; // название и производитель вакцины

    @Column (name = "valid_until")
    private Instant validUntil; // действие до

    public Vaccine() { }

    /* Getters and Setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VaccineType getType() {
        return type;
    }

    public void setType(VaccineType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getVaccineBatchNumber() {
        return vaccineBatchNumber;
    }

    public void setVaccineBatchNumber(String vaccineBatchNumber) {
        this.vaccineBatchNumber = vaccineBatchNumber;
    }

    public String getVaccineNameAndManufacturer() {
        return vaccineNameAndManufacturer;
    }

    public void setVaccineNameAndManufacturer(String vaccineNameAndManufacturer) {
        this.vaccineNameAndManufacturer = vaccineNameAndManufacturer;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public Animal getAnimal() {
      return animal;
    }

    public void setAnimal(Animal animal) {
      this.animal = animal;
    }

  @Override
    public String toString() {
      return "Vaccine{" +
        "id=" + id +
        ", animal=" + animal +
        ", type='" + type + '\'' +
        ", title='" + title + '\'' +
        ", date=" + date +
        ", vaccineBatchNumber='" + vaccineBatchNumber + '\'' +
        ", vaccineNameAndManufacturer='" + vaccineNameAndManufacturer + '\'' +
        ", validUntil=" + validUntil +
        '}';
    }
}
