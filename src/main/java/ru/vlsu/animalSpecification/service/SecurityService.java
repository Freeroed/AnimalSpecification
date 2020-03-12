package ru.vlsu.animalSpecification.service;

/**
 * Service for Security
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String userName, String password);
}
