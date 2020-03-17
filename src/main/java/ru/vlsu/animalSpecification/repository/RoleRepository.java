package ru.vlsu.animalSpecification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlsu.animalSpecification.domain.Role;
import ru.vlsu.animalSpecification.domain.emun.ERole;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
