package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;
// порода животного
@Entity
@Table(name = "Breeds_of_animal")
public class BreedsOfAnimal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "breed_name")
    private String breedName; // название породы

    @Column (name = "breed_name_ENG")
    private String breedNameENG; // название породы на английском

    @Column (name = "scientific_name_ENG")
    private String scientificNameENG; // научное наименование породы

    @Column (name = "animal_type")
    private Long animalType; // id типа животного, к которому относится данная порода

    /* Getters and Setters */

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

    public String getScientificNameENG() {
      return scientificNameENG;
    }

    public void setScientificNameENG(String scientificNameENG) {
      this.scientificNameENG = scientificNameENG;
    }

    public Long getAnimalType() {
      return animalType;
    }

    public void setAnimalType(Long animalType) {
      this.animalType = animalType;
    }
}
