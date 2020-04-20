package ru.vlsu.animalSpecification.service.mapper;


import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.Role;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.domain.emun.ERole;
import ru.vlsu.animalSpecification.service.dto.UserDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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

    public User UserDTOtoUser(UserDTO userDTO) {
      if (userDTO == null) {
        return null;
      } else {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setPatronymic(userDTO.getPatronymic());
        user.setNameEng(userDTO.getNameEng());
        user.setSurnameEng(userDTO.getSurnameEng());
        user.setRoles(rolesFromEnum(userDTO.getRoles()));
        user.setAddress(userDTO.getAddress());
        user.setInn(userDTO.getInn());
        user.setPhone(userDTO.getPhone());
      }
      return new User();
    }

    private Set<Role> rolesFromEnum(Set<ERole> rolesAsEnum) {
      Set<Role> roles = new HashSet<>();

      if(rolesAsEnum != null) {
        roles = rolesAsEnum.stream().map(eRole -> {
          Role role = new Role();
          role.setName(eRole);
          return role;
        }).collect(Collectors.toSet());
      }
      return roles;
    }


}
