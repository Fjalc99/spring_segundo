package com.salesianostriana.dam.monumentos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(description = "API para la gestión de monumentos",
		title = "Monumentos API",
		version = "3.0",
		contact = @Contact(name = "Francisco José Alcantarilla Calado",
		           email = "alcantarilla.cafra24@triana.salesianos.edu")))
public class MonumentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonumentosApplication.class, args);
	}

}
