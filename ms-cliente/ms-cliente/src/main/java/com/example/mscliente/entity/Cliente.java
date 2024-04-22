package com.example.mscliente.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// La anotación @Entity indica que esta clase es una entidad JPA, es decir, se mapeará a una tabla en la base de datos
@Entity
@Data
public class Cliente {
    // La anotación @Id indica que este campo es la clave primaria de la entidad
    @Id
    // La anotación @GeneratedValue especifica la estrategia de generación de valores para la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Campo que representa el ID del cliente

    private String nombre; // Campo que representa el nombre del cliente
    private String dni; // Campo que representa el número de identificación del cliente
    private String direccion; // Campo que representa la dirección del cliente
    private Integer telefono; // Campo que representa el número de teléfono del cliente
}