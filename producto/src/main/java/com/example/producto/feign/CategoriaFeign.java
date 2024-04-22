package com.example.producto.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.producto.dto.Categoria;

// Interfaz para comunicarse con el servicio remoto de gestión de categorías
@FeignClient(name = "categoria-service", path = "/categoria")
public interface CategoriaFeign {

    // Método para obtener una categoría por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> listById(@PathVariable(required = true) Integer id);
}