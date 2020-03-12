package ru.vlsu.animalSpecification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlsu.animalSpecification.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
