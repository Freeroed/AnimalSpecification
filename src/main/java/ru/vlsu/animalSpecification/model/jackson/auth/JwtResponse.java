package ru.vlsu.animalSpecification.model.jackson.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JwtResponse {
  @JsonProperty("token")
  private String token;

  @JsonProperty("account")
  private AccountResponse account;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public AccountResponse getAccount() {
    return account;
  }

  public void setAccount(AccountResponse account) {
    this.account = account;
  }

  public JwtResponse(String token, AccountResponse account) {
    this.token = token;
    this.account = account;
  }

  public JwtResponse() {
  }
}
