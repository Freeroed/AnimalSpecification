package ru.vlsu.animalSpecification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeConfig {
  @Bean
  public FormattingConversionService conversionService() {
    DefaultFormattingConversionService conversionService =
      new DefaultFormattingConversionService(false);

    DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
    registrar.setDateFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
    registrar.registerFormatters(conversionService);

    // other desired formatters

    return conversionService;
  }
}
