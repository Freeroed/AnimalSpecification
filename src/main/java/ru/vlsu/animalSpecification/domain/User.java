package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "login")
    private String userName;


    @Column(name = "password")
    private String password;


    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "INN")
    private String inn;

    @Column(name = "surname_ENG")
    private String surnameEng;

    @Column(name = "name_ENG")
    private String nameEng;

    @Column(name = "email")
    private String email;

    @Column(name = "created_at")
    private Instant createdAd;

    @Column(name = " rosselkhoznadzor_division")
    private Long  rosselkhoznadzorDivision;

    @Column(name = "position")
    private String position;

    @Column(name = "position_ENG")
    private String positionENG;

    @Column(name = "organization")
    private String organization;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getSurnameEng() {
        return surnameEng;
    }

    public void setSurnameEng(String surnameEng) {
        this.surnameEng = surnameEng;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getCreatedAd() {
        return createdAd;
    }

    public void setCreatedAd(Instant createdAd) {
        this.createdAd = createdAd;
    }

    public Long getRosselkhoznadzorDivision() {
      return rosselkhoznadzorDivision;
    }

    public void setRosselkhoznadzorDivision(Long rosselkhoznadzorDivision) {
      this.rosselkhoznadzorDivision = rosselkhoznadzorDivision;
    }

    public String getPosition() {
      return position;
    }

    public void setPosition(String position) {
      this.position = position;
    }

    public String getPositionENG() {
      return positionENG;
    }

    public void setPositionENG(String positionENG) {
      this.positionENG = positionENG;
    }

    public String getOrganization() {
      return organization;
    }

    public void setOrganization(String organization) {
      this.organization = organization;
    }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", userName='" + userName + '\'' +
      ", password='" + password + '\'' +
      ", roles=" + roles +
      ", surname='" + surname + '\'' +
      ", name='" + name + '\'' +
      ", patronymic='" + patronymic + '\'' +
      ", phone='" + phone + '\'' +
      ", address='" + address + '\'' +
      ", inn='" + inn + '\'' +
      ", surnameEng='" + surnameEng + '\'' +
      ", nameEng='" + nameEng + '\'' +
      ", email='" + email + '\'' +
      ", createdAd=" + createdAd +
      '}';
  }


  public User() {
  }
}
