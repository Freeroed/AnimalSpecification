package ru.vlsu.animalSpecification.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.animalSpecification.domain.Role;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.domain.emun.ERole;
import ru.vlsu.animalSpecification.model.jackson.auth.JwtResponse;
import ru.vlsu.animalSpecification.model.jackson.auth.LoginRequest;
import ru.vlsu.animalSpecification.model.jackson.auth.MessageResponse;
import ru.vlsu.animalSpecification.model.jackson.auth.SignupRequest;
import ru.vlsu.animalSpecification.repository.RoleRepository;
import ru.vlsu.animalSpecification.repository.UserRepository;
import ru.vlsu.animalSpecification.security.jwt.JwtUtils;
import ru.vlsu.animalSpecification.service.impl.UserDetailsImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

  //TODO log
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
      .map(item -> item.getAuthority())
      .collect(Collectors.toList());
    return ResponseEntity.ok(new JwtResponse(jwt,
                                              userDetails.getId(),
                                              userDetails.getUsername(),
                                              userDetails.getEmail(),
                                              roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
    //TODO log
    if(userRepository.existsByUserName(signupRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("ERROR: username is already exist"));
    }

    if(userRepository.existsByEmail(signupRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("ERROR: email is already in use!"));
    }


    User user  = new User();
    user.setUserName(signupRequest.getUsername());
    user.setPassword(signupRequest.getPassword());
    user.setEmail(signupRequest.getEmail());

    Set<Role> roles = new HashSet<>();
    Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN).get();
    roles.add(userRole);
    user.setRoles(roles);
    userRepository.save(user);
    //TODO return new user
    return ResponseEntity.ok(new MessageResponse("User registered successfully"));
  }
}
