package com.fiap.g5.mscustomer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .openapi("3.0.1")
                .info(new Info()
                        .title("Customer API")
                        .version("1.0")
                        .description("Documentação da API de Clientes")
                        .contact(new Contact()
                                .name("Suporte")
                                .email("suporte@g5.com")));
    }
}