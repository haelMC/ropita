package com.example.msproveedor.Repository;

import com.example.msproveedor.Entity.Proveedor; //importa la clase provedor
import org.springframework.data.jpa.repository.JpaRepository; //importa la interfaz


public interface ProveedorRespository extends JpaRepository<Proveedor, Integer> {
}
