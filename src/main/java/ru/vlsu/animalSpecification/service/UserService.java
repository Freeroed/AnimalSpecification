package ru.vlsu.animalSpecification.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.service.dto.UserDTO;

import java.util.Optional;

@Transactional
public interface UserService {

    @Transactional(readOnly = true)
    void save(User user);

    @Transactional(readOnly = true)
    Optional<User> findOneByUserName(String userName);

    @Transactional(readOnly = true)
    User findByUserName(String userName);

    @Transactional(readOnly = true)
    Page<UserDTO> getAllUsers(Pageable pageable);

}
