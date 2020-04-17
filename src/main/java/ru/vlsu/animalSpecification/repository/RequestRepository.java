package ru.vlsu.animalSpecification.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.domain.User;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Long> {
    List<Request> findAllByRecipient(User recipient);
}
