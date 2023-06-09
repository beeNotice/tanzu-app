package com.tanzu.app.config;

import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class TanzuAppConfiguration {

  // Bean to use the httptrace actuator endpoint
  @Bean
  public InMemoryHttpExchangeRepository createTraceRepository() {
    return new InMemoryHttpExchangeRepository();
  }

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
            .components(new Components())
            .info(new Info()
                .title("Tanzu App - OpenAPI 3.0")
                .version("1.0.0")
                .description("This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
  }
}
