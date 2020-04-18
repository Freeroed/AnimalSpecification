package ru.vlsu.animalSpecification.service.mapper;

import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.service.dto.VaccineDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VaccineMapper {

  public List<VaccineDTO> vaccinesToVaccinesDTO(List<Vaccine> vaccines) {
    return  vaccines.stream()
      .filter(Objects::nonNull)
      .map(this::vaccineToVaccineDTO)
      .collect(Collectors.toList());
  }

  public VaccineDTO vaccineToVaccineDTO(Vaccine vaccine) {
    return  new VaccineDTO(vaccine);
  }
}
