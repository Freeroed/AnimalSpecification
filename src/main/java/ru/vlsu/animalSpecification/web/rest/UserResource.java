package ru.vlsu.animalSpecification.web.rest;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {

  private static final Logger log = Logger.getLogger(UserResource.class);

  private final UserService userService;

  public UserResource(UserService userService) {
    this.userService = userService;
  }


  @GetMapping("/users")
  public ResponseEntity getAllUsers(){
    log.debug("REST request to get all users");

    return ResponseEntity.ok()
      .body(userService.findByUsername("admin"));
  }
}
