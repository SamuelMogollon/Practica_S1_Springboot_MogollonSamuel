package com.s1.gestion_producto.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.awt.SystemColor.info;

@Configuration

public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API DOCUMENTADA DE CAMPUSLANDS")
                        .version("1.0")
                        .description("ESTA API, se construyo como practica para lograr hacer el proyecto"));
    }
}
