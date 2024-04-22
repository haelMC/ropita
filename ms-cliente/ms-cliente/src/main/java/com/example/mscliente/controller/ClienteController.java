package com.example.mscliente.controller;

import com.example.mscliente.entity.Cliente;
import com.example.mscliente.service.ClienteService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    // Maneja las solicitudes GET para obtener todos los clientes
    @GetMapping()
    public ResponseEntity<List<Cliente>> list() {
        return ResponseEntity.ok(clienteService.listar());
    }

    // Maneja las solicitudes POST para guardar un nuevo cliente
    @PostMapping()
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.guardar(cliente));
    }

    // Maneja las solicitudes PUT para actualizar un cliente existente
    @PutMapping()
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.actualizar(cliente));
    }

    // Utiliza la anotación CircuitBreaker para manejar las solicitudes GET para obtener un cliente por su ID
    // Si hay un fallo, se activa el circuito y se llama al método de fallback
    @CircuitBreaker(name = "clienteListarPorIdCB", fallbackMethod = "fallBackClienteListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(clienteService.listarPorId(id).get());
    }

    // Maneja las solicitudes DELETE para eliminar un cliente por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Cliente>> deleteById(@PathVariable(required = true) Integer id) {
        clienteService.eliminarPorId(id);
        return ResponseEntity.ok(clienteService.listar());
    }

    // Método de fallback en caso de fallo al obtener un cliente por su ID
    private ResponseEntity<Cliente> fallBackClienteListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Cliente cliente = new Cliente();
        cliente.setId(90000); // Se establece un ID de cliente predeterminado en caso de fallo
        return ResponseEntity.ok().body(cliente);
    }
}
