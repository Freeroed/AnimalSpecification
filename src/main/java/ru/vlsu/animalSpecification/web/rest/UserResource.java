package ru.vlsu.animalSpecification.web.rest;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    private static final Logger log = Logger.getLogger(UserResource.class);
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/users/get")
    public User findUserByUserName(){
        log.debug("Request to get user by username by Rest");
        User user = userService.findByUserName("admin");
        return user;
    }
}
