package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Rosselkhoznadzor_division")
public class RosselkhoznadzorDivision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "name_ENG")
    private String nameENG;

    public RosselkhoznadzorDivision() { }

    /* Getters and Setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameENG() {
        return nameENG;
    }

    public void setNameENG(String nameENG) {
        this.nameENG = nameENG;
    }
}
