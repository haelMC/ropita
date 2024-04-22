package com.example.msproveedor.Service.Impl;

import com.example.msproveedor.Entity.Proveedor; // Importa la clase Proveedor
import com.example.msproveedor.Repository.ProveedorRespository; // Importa la interfaz ProveedorRepository
import com.example.msproveedor.Service.ProveedorService; // Importa la interfaz ProveedorService
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación Autowired de Spring
import org.springframework.stereotype.Service; // Importa la anotación Service de Spring

import java.util.List; // Importa la interfaz List de Java
import java.util.Optional; // Importa la clase Optional de Java

@Service // Indica que esta clase es un servicio de Spring
public class ProveedorServiceImpl implements ProveedorService  {

    @Autowired // Inyección de dependencias para conectar con el repositorio
    private ProveedorRespository proveedorRespository; // Instancia del repositorio

    @Override // Anotación para indicar que se está sobreescribiendo un método de la interfaz
    public List<Proveedor> listar() {
        return proveedorRespository.findAll(); // Retorna todos los proveedores
    }

    @Override // Anotación para indicar que se está sobreescribiendo un método de la interfaz
    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRespository.save(proveedor); // Guarda un proveedor en la base de datos
    }

    @Override // Anotación para indicar que se está sobreescribiendo un método de la interfaz
    public Proveedor actualizar(Proveedor proveedor) {
        return proveedorRespository.save(proveedor); // Actualiza un proveedor en la base de datos
    }

    @Override // Anotación para indicar que se está sobreescribiendo un método de la interfaz
    public Optional<Proveedor> listarPorId(Integer id) {
        return proveedorRespository.findById(id); // Busca un proveedor por su ID en la base de datos
    }

    @Override // Anotación para indicar que se está sobreescribiendo un método de la interfaz
    public void eliminarPorId(Integer id) {
        proveedorRespository.deleteById(id); // Elimina un proveedor por su ID de la base de datos
    }
}
