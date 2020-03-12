package ru.vlsu.animalSpecification.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vlsu.animalSpecification.domain.Role;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.repository.RoleRepository;
import ru.vlsu.animalSpecification.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
@Service
public class UserServiceImpl implements UserService{

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user){
        log.debug("Request to save user by Service {}");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1L));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName){
        log.debug("Request to Find user by username by Service");
        User user = userRepository.findByUserName(userName);
        log.debug("response user by service :  " + user);
        return user;
    }



}
