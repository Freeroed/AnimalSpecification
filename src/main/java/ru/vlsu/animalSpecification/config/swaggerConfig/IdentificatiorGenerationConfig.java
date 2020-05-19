package ru.vlsu.animalSpecification.config.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.vlsu.animalSpecification.service.IdentificatorGenerationService;

@Configuration
public class IdentificatiorGenerationConfig {

  @Bean
  public IdentificatorGenerationService identificatorGenerationService() {
    return new IdentificatorGenerationService();
  }
}
