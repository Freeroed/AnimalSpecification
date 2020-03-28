package ru.vlsu.animalSpecification.service.dto;

import ru.vlsu.animalSpecification.domain.BreedsOfAnimal;

public class BreedsOfAnimalDTO {

  private Long id;

  private String breedName; // название породы

  private String breedNameENG; // название породы на английском

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBreedName() {
    return breedName;
  }

  public void setBreedName(String breedName) {
    this.breedName = breedName;
  }

  public String getBreedNameENG() {
    return breedNameENG;
  }

  public void setBreedNameENG(String breedNameENG) {
    this.breedNameENG = breedNameENG;
  }

  public BreedsOfAnimalDTO(BreedsOfAnimal breedsOfAnimal) {
    this.id = breedsOfAnimal.getId();
    this.breedName = breedsOfAnimal.getBreedName();
    this.breedNameENG = breedsOfAnimal.getBreedNameENG();
  }

  @Override
  public String toString() {
    return "BreedsOfAnimalDTO{" +
      "id=" + id +
      ", breedName='" + breedName + '\'' +
      ", breedNameENG='" + breedNameENG + '\'' +
      '}';
  }
}
