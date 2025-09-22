package com.labs.aluguel.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API - Sistema de Aluguel (Lab02S02)")
                        .description("CRUD de Cliente - Spring Boot MVC + H2 + Swagger UI")
                        .version("1.0.0"));
    }
}
