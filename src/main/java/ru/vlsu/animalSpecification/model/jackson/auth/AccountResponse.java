package ru.vlsu.animalSpecification.model.jackson.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class AccountResponse implements Serializable {

  @JsonProperty("username")
  private String username;

  @JsonProperty("email")
  private String email;

  @JsonProperty("roles")
  private List<String> roles;

  public AccountResponse(String username, String email, List<String> roles) {
    this.username = username;
    this.email = email;
    this.roles = roles;
  }

  public AccountResponse() {
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
}
