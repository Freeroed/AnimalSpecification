package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Region")
public class Region implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column (name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name = "name_ENG")
    private String nameEng;

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String name_ENG) {
        this.nameEng = name_ENG;
    }

    public Region(){}

    @Override
    public String toString() {
      return "Region{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", nameEng='" + nameEng + '\'' +
        '}';
    }
}
