package com.example.msproveedor.Service;

import com.example.msproveedor.Entity.Proveedor; // Importa la clase Proveedor

import java.util.List; // Importa la interfaz List de Java
import java.util.Optional; // Importa la clase Optional de Java

// Interfaz que define los métodos que puede realizar un servicio relacionado con la entidad Proveedor
public interface ProveedorService {

    // Método para listar todos los proveedores
    public List<Proveedor> listar();

    // Método para guardar un proveedor
    public Proveedor guardar(Proveedor proveedor);

    // Método para actualizar un proveedor
    public Proveedor actualizar(Proveedor proveedor);

    // Método para obtener un proveedor por su ID
    public Optional<Proveedor> listarPorId(Integer id);

    // Método para eliminar un proveedor por su ID
    public void eliminarPorId(Integer id);
}
