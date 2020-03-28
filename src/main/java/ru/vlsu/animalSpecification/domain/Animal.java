package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "Animal")
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nickname")
    private String nickname; // кличка

    @Column (name = "sex")
    private char sex; // пол

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type", nullable = false)
    private TypeOfAnimal type; // кошка/собака/хомяк (id типа)

    @Column (name = "chip")
    private String chip; // чип

    @Column (name = "weight")
    private Integer weight; // вес

    @Column (name = "birthday")
    private Instant birthday; // дата рождения

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "breed", nullable = false)
    private BreedsOfAnimal breed; // порода (id)

    @Column (name = "color")
    private String color; //цвет

    @Column (name = "place_of_birth")
    private String placeOfBirth; // местро рождения

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "human", nullable = false)
    private User master;

    @Column (name = "TNVED_code")
    private String tnvedCode; // код ТНВЭД

    @Column (name = "color_ENG")
    private String colorENG; // цвет на английском

  public User getMaster() {
    return master;
  }

  public void setMaster(User master) {
    this.master = master;
  }



    /*
        Getters and Setters
    */

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

    public TypeOfAnimal getType() {
        return type;
    }

    public void setType(TypeOfAnimal type) {
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

    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public BreedsOfAnimal getBreed() {
        return breed;
    }

    public void setBreed(BreedsOfAnimal breed) {
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

  @Override
  public String toString() {
    return "Animal{" +
      "id=" + id +
      ", nickname='" + nickname + '\'' +
      ", sex=" + sex +
      ", type=" + type +
      ", chip='" + chip + '\'' +
      ", weight=" + weight +
      ", birthday=" + birthday +
      ", breed=" + breed +
      ", color='" + color + '\'' +
      ", placeOfBirth='" + placeOfBirth + '\'' +
      ", tnvedCode='" + tnvedCode + '\'' +
      ", colorENG='" + colorENG + '\'' +
      '}';
  }
}

