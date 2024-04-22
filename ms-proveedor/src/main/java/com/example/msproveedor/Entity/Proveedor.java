package com.example.msproveedor.Entity;

import jakarta.persistence.Entity; // Importa la anotación Entity de Jakarta Persistence
import jakarta.persistence.GeneratedValue; // Importa la anotación GeneratedValue de Jakarta Persistence
import jakarta.persistence.GenerationType; // Importa la enumeración GenerationType de Jakarta Persistence
import jakarta.persistence.Id; // Importa la anotación Id de Jakarta Persistence
import lombok.Data; // Importa la anotación Data de Lombok

@Data // Anotación Lombok para generar automáticamente getters, setters, toString, equals, y hashCode
@Entity // Marca esta clase como una entidad JPA, que se mapeará a una tabla en la base de datos
public class Proveedor {

    @Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente el valor de este campo utilizando una estrategia de incremento automático
    private Integer Id; // Campo para almacenar el ID del proveedor

    private String nombre; // Campo para almacenar el nombre del proveedor
    private String empresa; // Campo para almacenar el nombre de la empresa del proveedor
    private String direccion; // Campo para almacenar la dirección del proveedor
    private Integer telefono; // Campo para almacenar el número de teléfono del proveedor
}
