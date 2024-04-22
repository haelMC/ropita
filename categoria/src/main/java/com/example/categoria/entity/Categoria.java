package com.example.categoria.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Categoria {
    // Identificador único de la categoría
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Título de la categoría
    private String titulo;

    // Descripción de la categoría
    private String descripccion; // Parece haber un error en el nombre del atributo "descripción"

    // Etiqueta asociada a la categoría
    private String etiqueta;

    // Color asociado a la categoría
    private String color;
}
