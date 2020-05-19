package ru.vlsu.animalSpecification.service;

import java.time.Instant;

public class IdentificatorGenerationService {
  // генерация номера заявки
  public String generateRequestNumber(Long userId){
    String result = Instant.now().toEpochMilli() + "" + userId;
    return result;
  }
}
