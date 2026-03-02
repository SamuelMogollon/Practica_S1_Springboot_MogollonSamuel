package com.s1.gestion_producto.repository;

import com.s1.gestion_producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    Producto findByNombreIgnoreCase(String nombre);
    boolean existsByNombre(String nombre);
    Long countByNombre(String nombre);
}
