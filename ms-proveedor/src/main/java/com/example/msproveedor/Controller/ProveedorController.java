package com.example.msproveedor.Controller;

import com.example.msproveedor.Entity.Proveedor;
import com.example.msproveedor.Service.ProveedorService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorController {

    // Inyección de dependencias del servicio ProveedorService
    @Autowired
    private ProveedorService proveedorService;

    // Método para obtener una lista de proveedores
    @GetMapping()
    public ResponseEntity<List<Proveedor>> list() {
        return ResponseEntity.ok().body(proveedorService.listar());
    }

    // Método para guardar un nuevo proveedor
    @PostMapping
    public ResponseEntity<Proveedor> save(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorService.guardar(proveedor));
    }

    // Método para actualizar un proveedor existente
    @PutMapping()
    public ResponseEntity<Proveedor> update(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorService.actualizar(proveedor));
    }

    // Método para obtener un proveedor por su ID
    @CircuitBreaker(name = "proveedorListarPorIdCB", fallbackMethod = "fallBackProveedorListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> listById(@PathVariable(required = true) Integer id) {
        Optional<Proveedor> proveedor = proveedorService.listarPorId(id);
        if (proveedor.isPresent()) {
            return ResponseEntity.ok(proveedor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para eliminar un proveedor por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Proveedor>> deleteById(@PathVariable(required = true) Integer id) {
        proveedorService.eliminarPorId(id);
        return ResponseEntity.ok(proveedorService.listar());
    }

    // Método de fallback para manejar fallos en la operación de obtener proveedor por ID
    private ResponseEntity<Proveedor> fallBackProveedorListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        // En caso de fallo, se retorna un proveedor de respaldo con ID 90000
        Proveedor proveedor = new Proveedor();
        proveedor.setId(90000);
        return ResponseEntity.ok().body(proveedor);
    }
}
