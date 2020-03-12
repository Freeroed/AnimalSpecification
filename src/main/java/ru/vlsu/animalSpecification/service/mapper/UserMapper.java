package ru.vlsu.animalSpecification.service.mapper;


import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.service.dto.UserDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public List<UserDTO> usersToUserDTO(List<User> users) {
        return  users.stream()
                .filter(Objects::nonNull)
                .map(this::userToUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user);
    }


}
