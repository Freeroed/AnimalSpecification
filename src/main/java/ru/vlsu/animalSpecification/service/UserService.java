package ru.vlsu.animalSpecification.service;

import ru.vlsu.animalSpecification.domain.User;

public interface UserService {

    void save(User user);

    User findByUserName(String userName);

}
