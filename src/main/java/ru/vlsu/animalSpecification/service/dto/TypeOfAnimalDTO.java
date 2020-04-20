package ru.vlsu.animalSpecification.service.dto;

import ru.vlsu.animalSpecification.domain.TypeOfAnimal;

public class TypeOfAnimalDTO {

  private Long id;

  private String typeName;

  private String typeNameENG;

  private String scientificNameENG;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public String getTypeNameENG() {
    return typeNameENG;
  }

  public void setTypeNameENG(String typeNameENG) {
    this.typeNameENG = typeNameENG;
  }

  public String getScientificNameENG() {
    return scientificNameENG;
  }

  public void setScientificNameENG(String scientificNameENG) {
    this.scientificNameENG = scientificNameENG;
  }

  public TypeOfAnimalDTO(TypeOfAnimal typeOfAnimal) {
    this.id = typeOfAnimal.getId();
    this.typeNameENG = typeOfAnimal.getTypeNameENG();
    this.typeName = typeOfAnimal.getTypeName();
    this.scientificNameENG = typeOfAnimal.getScientificNameENG();
  }

  public TypeOfAnimalDTO() {
  }

  @Override
  public String toString() {
    return "TypeOfAnimalDTO{" +
      "id=" + id +
      ", typeName='" + typeName + '\'' +
      ", typeNameENG='" + typeNameENG + '\'' +
      ", scientificNameENG='" + scientificNameENG + '\'' +
      '}';
  }
}
