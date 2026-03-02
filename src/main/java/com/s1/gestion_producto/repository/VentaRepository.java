package com.s1.gestion_producto.repository;

import com.s1.gestion_producto.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VentaRepository extends JpaRepository <Venta, Long>{
    Long countByFecha(LocalDate fecha);
}
