package ru.vlsu.animalSpecification.service.dto;

import ru.vlsu.animalSpecification.domain.Role;
import ru.vlsu.animalSpecification.domain.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {

    private Long id;

    private String userName;

    private String surname;

    private String name;

    private String patronymic;

    private String phone;

    private String address;

    private String inn;

    private String surnameEng;

    private String nameEng;

    private Set<String> roles;

    public UserDTO(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.patronymic = user.getPatronymic();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.inn = user.getInn();
        this.surnameEng = user.getSurnameEng();
        this.nameEng = user.getNameEng();
        this.roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
