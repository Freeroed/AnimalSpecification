package ru.vlsu.animalSpecification.domain;


import javax.persistence.*;

//@Entity
//@Table(name = "Region")
public class Region {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   // @Column (name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   // @Column (name = "name_ENG")
    private String name_ENG;

    public String getName_ENG() {
        return name_ENG;
    }

    public void setName_ENG(String name_ENG) {
        this.name_ENG = name_ENG;
    }

    public Region(){}


}
