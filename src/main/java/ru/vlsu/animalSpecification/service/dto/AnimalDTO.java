package ru.vlsu.animalSpecification.service.dto;

public class AnimalDTO {

  private Long id;

  private String nickname;

  private char sex;

  private Long type;

  private String chip;

  private Integer weight;

  private Long breed;

  private String color;

  private String placeOfBirth;

  private Long human;

  private String tnvedCde;

  private String colorENG;

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

  public Long getType() {
    return type;
  }

  public void setType(Long type) {
    this.type = type;
  }

  public String getChip() {
    return chip;
  }

  public void setChip(String chip) {
    this.chip = chip;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Long getBreed() {
    return breed;
  }

  public void setBreed(Long breed) {
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

  public Long getHuman() {
    return human;
  }

  public void setHuman(Long human) {
    this.human = human;
  }

  public String getTnvedCde() {
    return tnvedCde;
  }

  public void setTnvedCde(String tnvedCde) {
    this.tnvedCde = tnvedCde;
  }

  public String getColorENG() {
    return colorENG;
  }

  public void setColorENG(String colorENG) {
    this.colorENG = colorENG;
  }
}
