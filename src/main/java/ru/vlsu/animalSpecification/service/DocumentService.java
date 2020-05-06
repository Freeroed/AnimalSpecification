package ru.vlsu.animalSpecification.service;


import ru.vlsu.animalSpecification.domain.Document;

public interface DocumentService {
  boolean createDocument();
  Document get(Long id);
}
