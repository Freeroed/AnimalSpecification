package ru.vlsu.animalSpecification.service.mapper;

import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
import ru.vlsu.animalSpecification.service.dto.AnimalDTO;
import ru.vlsu.animalSpecification.service.dto.LaboratoryResearchDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LaboratoryResearchMapper {

  public List<LaboratoryResearchDTO> laboratoryResearchesToLaboratoryResearchesDTO(List<LaboratoryResearch> laboratoryResearches){
    return laboratoryResearches.stream()
      .filter(Objects::nonNull)
      .map(this::laboratoryResearchToLaboratoryResearchDTO)
      .collect(Collectors.toList());

  }

  public LaboratoryResearchDTO laboratoryResearchToLaboratoryResearchDTO(LaboratoryResearch laboratoryResearch) {
    return new LaboratoryResearchDTO(laboratoryResearch);
  }

  public LaboratoryResearch toEntity(LaboratoryResearchDTO laboratoryResearchDTO) {
    if (laboratoryResearchDTO == null) {
      return null;
    } else {
      LaboratoryResearch research = new LaboratoryResearch();
      research.setId(research.getId());
      research.setLaboratory(laboratoryResearchDTO.getLaboratory());
      research.setDateOfReceiptOfResult(laboratoryResearchDTO.getDateOfReceiptOfResult());
      research.setResearchMethod(laboratoryResearchDTO.getResearchMethod());
      research.setExaminationNumber(laboratoryResearchDTO.getExaminationNumber());
      research.setResult(laboratoryResearchDTO.getResult());
      research.setAnimal(animalFromAnimalDTO(laboratoryResearchDTO.getAnimal()));
      return  research;
    }
  }

  private Animal animalFromAnimalDTO(AnimalDTO animalDTO) {
    if (animalDTO == null) {
      return  null;
    } else {
      Animal animal = new Animal();
      animal.setId(animalDTO.getId());
      return animal;
    }
  }
}
