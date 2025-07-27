package com.portafolio.apiCine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "API de Cine",
				version = "1.0",
				description = "API REST para gestión de películas, directores y actores."
		)
)
@SpringBootApplication
@EnableCaching
public class ApiCineApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiCineApplication.class, args);
	}
}