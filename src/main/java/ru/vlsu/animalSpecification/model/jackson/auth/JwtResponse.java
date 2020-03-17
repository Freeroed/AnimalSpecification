package ru.vlsu.animalSpecification.model.jackson.auth;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JwtResponse {
  private String token;
  private long id;
  private String username;
  private String email;
  private List<String> roles;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public JwtResponse(String token, long id, String username, String email, List<String> roles) {
    this.token = token;
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
  }

  public JwtResponse() {
  }
}
