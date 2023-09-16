package com.example.topzona.conf;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "TOP ZONA REST API",
        contact = @Contact(
                name = "Vyatus",
                email = "Vyatus007@gmail.ru"
        ), version = "1.0",
        description = "it is TOP ZONA")
        )
public class OpenApiConfig {
}