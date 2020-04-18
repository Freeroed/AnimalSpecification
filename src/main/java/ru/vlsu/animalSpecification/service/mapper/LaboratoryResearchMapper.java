package ru.vlsu.animalSpecification.service.mapper;

import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.LaboratoryResearch;
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
}
