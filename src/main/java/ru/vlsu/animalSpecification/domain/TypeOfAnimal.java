package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Type_of_animal")
public class TypeOfAnimal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "type_name_ENG")
    private String typeNameENG;

    @Column(name = "scientific_name_ENG")
    private String scientificNameENG;

    /* Gettersand Setters */

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

    @Override
    public String toString() {
      return "TypeOfAnimal{" +
        "id=" + id +
        ", typeName='" + typeName + '\'' +
        ", typeNameENG='" + typeNameENG + '\'' +
        ", scientificNameENG='" + scientificNameENG + '\'' +
        '}';
    }
}
