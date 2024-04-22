package com.example.producto.controller;

import com.example.producto.entity.Producto;
import com.example.producto.service.ProductoService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    // Inyección de dependencia del servicio de Producto
    @Autowired
    private ProductoService productoService;

    // Método para obtener todos los productos
    @GetMapping()
    public ResponseEntity<List<Producto>> list() {
        // Devuelve todos los productos disponibles
        return ResponseEntity.ok().body(productoService.listar());
    }

    // Método para guardar un nuevo producto
    @PostMapping()
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        // Guarda un nuevo producto y devuelve el producto guardado
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    // Método para actualizar un producto existente
    @PutMapping()
    public ResponseEntity<Producto> update(@RequestBody Producto producto) {
        // Actualiza un producto existente y devuelve el producto actualizado
        return ResponseEntity.ok(productoService.actualizar(producto));
    }

    // Método para obtener un producto por su ID
    @CircuitBreaker(name = "listByIdCB", fallbackMethod = "fallBacklistById")
    @GetMapping("/{id}")
    public ResponseEntity<Producto> listById(@PathVariable(required = true) Integer id) {
        // Obtiene un producto por su ID y lo devuelve
        return ResponseEntity.ok().body(productoService.listarPorId(id).get());
    }

    // Método para eliminar un producto por su ID
    @CircuitBreaker(name = "deleteByIdCB", fallbackMethod = "fallBackDeleteById")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        // Elimina un producto por su ID y devuelve un mensaje de confirmación
        productoService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }

    // Método de respaldo para la eliminación por ID en caso de error
    private String fallBackDeleteById(@PathVariable(required = true) Integer id, RuntimeException e) {
        // Devuelve una respuesta alternativa en caso de error al eliminar un producto por su ID
        return "Error al eliminar el registro.";
    }

    // Método de respaldo para obtener producto por ID en caso de error
    private ResponseEntity<Producto> fallBacklistById(@PathVariable(required = true) Integer id, RuntimeException e) {
        // Devuelve una respuesta alternativa en caso de error al obtener un producto por su ID
        return ResponseEntity.notFound().build();
    }
}
