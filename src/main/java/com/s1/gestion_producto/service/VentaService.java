package com.s1.gestion_producto.service;

import com.s1.gestion_producto.dto.request.VentaRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VentaService {
    VentaResponseDTO guardarVenta(VentaRequestDTO dto);
    VentaResponseDTO actualizarVenta(VentaRequestDTO dto, Long id);
    void eliminarVenta(Long id);
    List<VentaResponseDTO> buscarTodos();
    VentaResponseDTO buscarId(Long Id);
    boolean buscarExisteId(Long id);
    Long countByFecha (LocalDate fecha);
}