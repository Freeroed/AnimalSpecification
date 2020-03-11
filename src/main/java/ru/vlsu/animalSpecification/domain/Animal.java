package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;
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

    @Column (name = "type")
    private Long type; // кошка/собака/хомяк (id типа)

    @Column (name = "chip")
    private String chip; // чип

    @Column (name = "weight")
    private Integer weight; // вес

    @Column (name = "birthday")
    private Date birthday; // дата рождения

    @Column (name = "breed")
    private Long breed; // порода (id)

    @Column (name = "color")
    private String color; //цвет

    @Column (name = "place_of_birth")
    private String placeOfBirth; // местро рождения

    @Column (name = "human")
    private Long human; //хозяин животного

    @Column (name = "TNVED_code")
    private String tnvedCode; // код ТНВЭД

    @Column (name = "color_ENG")
    private String colorENG; // цвет на английском

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

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getBreed() {
        return breed;
    }

    public void setBreed(long breed) {
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

    public long getHuman() {
        return human;
    }

    public void setHuman(long human) {
        this.human = human;
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
}

