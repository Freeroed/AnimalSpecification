package ru.vlsu.animalSpecification.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.domain.emun.VaccineType;

import java.io.Serializable;
import java.time.Instant;

public class VaccineDTO implements Serializable {

  private Long id;

  private AnimalDTO animal;

  private VaccineType type;

  private String title;

  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "UTC")
  private Instant date; // дата проведения

  private String vaccineBatchNumber;

  private String vaccineNameAndManufacturer;

  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "UTC")
  private Instant validUntil;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AnimalDTO getAnimal() {
    return animal;
  }

  public void setAnimal(AnimalDTO animal) {
    this.animal = animal;
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

  public VaccineDTO(Vaccine vaccine) {
    this.id = vaccine.getId();
    this.animal = new AnimalDTO(vaccine.getAnimal());
    this.type = vaccine.getType();
    this.title = vaccine.getTitle();
    this.date = vaccine.getDate();
    this.vaccineBatchNumber = vaccine.getVaccineBatchNumber();
    this.vaccineNameAndManufacturer = vaccine.getVaccineNameAndManufacturer();
    this.validUntil = vaccine.getValidUntil();
  }


}
