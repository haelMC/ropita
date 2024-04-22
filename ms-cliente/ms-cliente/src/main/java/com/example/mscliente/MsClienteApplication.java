package com.example.mscliente;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsClienteApplication {

	// Método principal para iniciar la aplicación Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(MsClienteApplication.class, args);
	}

	// Bean para configurar la documentación de OpenAPI
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("OPEN API MICROSERVICIO CLIENTE") // Título de la documentación
				.version("0.0.1") // Versión del microservicio
				.description("servicio web cliente") // Descripción del microservicio
				.termsOfService("http://swagger.io/terms") // URL de los términos de servicio
				.license(new License().name("Apache 2.0").url("http://springdoc.org")) // Información de la licencia
		);
	}
}
