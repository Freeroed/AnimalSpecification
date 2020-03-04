package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
