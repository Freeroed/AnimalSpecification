package ru.vlsu.animalSpecification.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.debug("UserDetails Request fo found user by userName : " + username);
    User user = userRepository.findByUserName(username)
      .orElseThrow(() -> new UsernameNotFoundException("User not fount with username : " + username));
    log.debug(user.toString());
    return UserDetailsImpl.build(user);
  }
}
