package ru.vlsu.animalSpecification.web.rest;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.service.UserService;
import ru.vlsu.animalSpecification.service.UserServiceImpl;
import ru.vlsu.animalSpecification.service.dto.UserDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserResource {

    private static final Logger log = Logger.getLogger(UserResource.class);
    @Autowired
    UserService userService;

    @GetMapping("/users/get")
    public ResponseEntity findUserByUserName(){
        log.debug("Request to get user by username by Rest");
        return ResponseEntity.ok()
                .body(userService.findOneByUserName("admin").map(UserDTO::new));
        //return ResponseUtil.wrapOrNotFound(userService.findOneByUserName("admin").map(UserDTO::new));
    }
    //TODO drop me
    @GetMapping ("/users/getAdmin")
    public  User loadUserByUserName(){
        return userService.findByUserName("admin");
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> findAllUsers(Pageable pageable) {
        final Page<UserDTO> page = userService.getAllUsers(pageable);
        return  new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }
}
