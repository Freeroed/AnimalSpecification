package ru.vlsu.animalSpecification.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.repository.UserRepository;

@Service
@Transactional
public class UserService {

  private static final Logger log = LoggerFactory.getLogger(UserService.class);
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

 // @Transactional
  public User findByUsername(String username) {
    log.debug("Request to find user bu username : {}", username);
    return userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not fount with username : " + username));
  }
}
