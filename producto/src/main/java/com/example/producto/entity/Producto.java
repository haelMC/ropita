package com.example.producto.entity;

import java.time.LocalDateTime;

import com.example.producto.dto.Categoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Producto {
    // Identificador único del producto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nombre del producto
    private String nombre;

    // Costo del producto
    private String costo;

    // ID de la categoría a la que pertenece el producto
    private Integer categoriaId;

    // Tasa del Impuesto General a las Ventas (IGV) aplicada al producto
    private String tasaIGV;

    // Descripción del producto
    private String descripcion;

    // Código de barras del producto
    private String codigoBarras;

    // Cantidad en stock del producto
    private String cantidadStock;

    // Indicador de disponibilidad del producto
    private String disponible;

    // Proveedor del producto
    private String proveedor;

    // Atributo transient para representar la categoría del producto sin mapear a la base de datos
    @Transient
    private Categoria categoria;

}
