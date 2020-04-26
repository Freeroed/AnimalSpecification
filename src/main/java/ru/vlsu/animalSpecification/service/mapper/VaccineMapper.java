package ru.vlsu.animalSpecification.service.mapper;

import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.Animal;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.service.dto.AnimalDTO;
import ru.vlsu.animalSpecification.service.dto.VaccineDTO;

import javax.swing.text.html.parser.Entity;
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

  public Vaccine toEntity(VaccineDTO vaccineDTO) {
      if (vaccineDTO == null) {
        return null;
      } else {
        Vaccine vaccine = new Vaccine();
        vaccine.setId(vaccineDTO.getId());
        vaccine.setAnimal(animalFromAnimalDTO(vaccineDTO.getAnimal()));
        vaccine.setType(vaccineDTO.getType());
        vaccine.setTitle(vaccineDTO.getTitle());
        vaccine.setDate(vaccineDTO.getDate());
        vaccine.setVaccineBatchNumber(vaccineDTO.getVaccineBatchNumber());
        vaccine.setVaccineNameAndManufacturer(vaccineDTO.getVaccineNameAndManufacturer());
        vaccine.setValidUntil(vaccineDTO.getValidUntil());
        return vaccine;
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
