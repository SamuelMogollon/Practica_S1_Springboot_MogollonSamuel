package com.s1.gestion_producto.repository;

import com.s1.gestion_producto.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    List<DetalleVenta> findByVentaId(Long ventaId);
    List<DetalleVenta> findByProductoId(Long id);
}
