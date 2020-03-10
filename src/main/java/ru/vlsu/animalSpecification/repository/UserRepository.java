package ru.vlsu.animalSpecification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
