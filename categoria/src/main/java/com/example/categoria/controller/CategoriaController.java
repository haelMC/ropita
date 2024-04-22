package com.example.categoria.controller;

import com.example.categoria.entity.Categoria;
import com.example.categoria.service.CategoriaService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    // Inyección de dependencia del servicio de Categoría
    @Autowired
    private CategoriaService categoriaService;

    // Método para obtener todas las categorías
    @GetMapping()
    public ResponseEntity<List<Categoria>> list() {
        // Devuelve todas las categorías disponibles
        return ResponseEntity.ok().body(categoriaService.listar());
    }

    // Método para guardar una nueva categoría
    @PostMapping()
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
        // Guarda una nueva categoría y devuelve la categoría guardada
        return ResponseEntity.ok(categoriaService.guardar(categoria));
    }

    // Método para actualizar una categoría existente
    @PutMapping()
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {
        // Actualiza una categoría existente y devuelve la categoría actualizada
        return ResponseEntity.ok(categoriaService.actualizar(categoria));
    }

    // Método para obtener una categoría por su ID
    @CircuitBreaker(name = "listByIdCB", fallbackMethod = "fallBacklistById")
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> listById(@PathVariable(required = true) Integer id) {
        // Obtiene una categoría por su ID y la devuelve
        return ResponseEntity.ok().body(categoriaService.listarPorId(id).get());
    }

    // Método para eliminar una categoría por su ID
    @CircuitBreaker(name = "deleteByIdCB", fallbackMethod = "fallBackDeleteById")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        // Elimina una categoría por su ID y devuelve un mensaje de confirmación
        categoriaService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }

    // Método de respaldo para la eliminación por ID en caso de error
    private ResponseEntity<String> fallBackDeleteById(@PathVariable(required = true) Integer id, RuntimeException e) {
        // Devuelve una respuesta alternativa en caso de error al eliminar una categoría por su ID
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el registro.");
    }
}
