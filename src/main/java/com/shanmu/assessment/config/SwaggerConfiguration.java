package com.shanmu.assessment.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        type = SecuritySchemeType.HTTP,
        name = "Authorization",
        description = "authorization with JWT token",
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfiguration {
}
