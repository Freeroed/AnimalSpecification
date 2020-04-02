package ru.vlsu.animalSpecification.web.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vlsu.animalSpecification.service.UserService;
import ru.vlsu.animalSpecification.service.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class UserResource {

  private static final Logger log = Logger.getLogger(UserResource.class);

  private final UserService userService;

  private final HttpServletRequest httpServletRequest;

  @Autowired
  public UserResource(UserService userService, HttpServletRequest httpServletRequest) {
    this.userService = userService;
    this.httpServletRequest = httpServletRequest;
  }


  @GetMapping("/users")
  public ResponseEntity getAllUsers(){
    log.debug("REST request to get all users");

    return ResponseEntity.ok()
      .body(userService.findByUsername("admin"));
  }

  @GetMapping("/users/im")
  public ResponseEntity getMyAccount(){
    log.debug("REST request to get user account");
    String userName = httpServletRequest.getRemoteUser();
    UserDTO userDTO = new UserDTO(userService.findByUsername(userName));
    return ResponseEntity.ok().body(userDTO);
  }
}
