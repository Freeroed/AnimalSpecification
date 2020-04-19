package ru.vlsu.animalSpecification.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.emun.AnimalStatus;

import java.time.Instant;

public class AnimalDTO {

  private Long id;

  private String nickname;

  private char sex;

  private String chip;

  private BreedsOfAnimalDTO breed;

  private String color;

  private String placeOfBirth;

  private UserDTO master;

  private String tnvedCode;

  private String colorENG;

  private AnimalStatus status;

  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss",timezone = "UTC")
  private Instant birthday;

  private String inn;


  public Instant getBirthday() {
    return birthday;
  }

  public void setBirthday(Instant birthday) {
    this.birthday = birthday;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public char getSex() {
    return sex;
  }

  public void setSex(char sex) {
    this.sex = sex;
  }


  public String getChip() {
    return chip;
  }

  public void setChip(String chip) {
    this.chip = chip;
  }

  public BreedsOfAnimalDTO getBreed() {
    return breed;
  }

  public void setBreed(BreedsOfAnimalDTO breed) {
    this.breed = breed;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  public UserDTO getMaster() {
    return master;
  }

  public void setMaster(UserDTO master) {
    this.master = master;
  }

  public String getTnvedCode() {
    return tnvedCode;
  }

  public void setTnvedCode(String tnvedCode) {
    this.tnvedCode = tnvedCode;
  }

  public String getColorENG() {
    return colorENG;
  }

  public void setColorENG(String colorENG) {
    this.colorENG = colorENG;
  }

  public AnimalStatus getStatus() {
    return status;
  }

  public void setStatus(AnimalStatus status) {
    this.status = status;
  }

  public AnimalDTO(Animal animal) {
    this.id = animal.getId();
    this.nickname = animal.getNickname();
    this.sex = animal.getSex();
    this.chip = animal.getChip();
    this.breed = new BreedsOfAnimalDTO(animal.getBreed());
    this.color = animal.getColor();
    this.placeOfBirth = animal.getPlaceOfBirth();
    this.master = new UserDTO(animal.getMaster());
    this.tnvedCode = animal.getTnvedCode();
    this.colorENG = animal.getColorENG();
    this.status = animal.getStatus();
    this.birthday = animal.getBirthday();
  }
}
