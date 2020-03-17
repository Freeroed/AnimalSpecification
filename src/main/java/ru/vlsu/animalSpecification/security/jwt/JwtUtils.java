package ru.vlsu.animalSpecification.security.jwt;

import io.jsonwebtoken.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.vlsu.animalSpecification.service.impl.UserDetailsImpl;

import java.util.Date;

@Component
@PropertySource(value= {"classpath:application.properties"})
public class JwtUtils {
  private static final Logger log = Logger.getLogger(JwtUtils.class);

  @Value("${jwt.token.secret}")
  private String jwtSecret;

  @Value("${jwt.token.expired}")
  private int jwtExpiration;

  public String generateJwtToken(Authentication authentication) {
    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
    return Jwts.builder()
      .setSubject((userPrincipal.getUsername()))
      .setIssuedAt(new Date())
      .setExpiration(new Date((new Date().getTime() + jwtExpiration)))
      .signWith(SignatureAlgorithm.HS512, jwtSecret)
      .compact();
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      log.error("Invalid JWT signature : " + e.getMessage());
    } catch (MalformedJwtException e) {
      log.error("Invalid JWT token : " + e.getMessage());
    } catch (ExpiredJwtException e) {
      log.error("JWT token is expired : " + e.getMessage());
    } catch (UnsupportedJwtException e) {
      log.error("JWT token is unsupported : " + e.getMessage());
    } catch (IllegalArgumentException e) {
      log.error("JWT claims string is empty : " + e.getMessage());
    }

    return false;
  }
}
