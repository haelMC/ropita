package com.example.msproveedor;

import io.swagger.v3.oas.models.OpenAPI; // Importa la clase OpenAPI de Swagger
import io.swagger.v3.oas.models.info.Info; // Importa la clase Info de Swagger para la información de la API
import io.swagger.v3.oas.models.info.License; // Importa la clase License de Swagger para la licencia de la API
import org.springframework.boot.SpringApplication; // Importa la clase SpringApplication de Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa la anotación SpringBootApplication de Spring Boot
import org.springframework.context.annotation.Bean; // Importa la anotación Bean de Spring Framework

@SpringBootApplication // Indica que esta clase es una aplicación Spring Boot
public class MsProveedorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProveedorApplication.class, args); // Método principal para ejecutar la aplicación Spring Boot
    }

    // Método para configurar la documentación de la API utilizando Swagger
    @Bean
    public OpenAPI custoOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("OPEN API MICROSERVICIO INVENTARIO") // Título de la API
                .version("0.0.1") // Versión de la API
                .description("servicio web inventario") // Descripción de la API
                .termsOfService("http://swagger.io/terms") // Términos de servicio de la API
                .license(new License().name("Apache 2.0").url("http://springdoc.org")) // Información de la licencia de la API
        );
    }
}
