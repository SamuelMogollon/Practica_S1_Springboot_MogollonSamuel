package com.s1.gestion_producto.service;

import com.s1.gestion_producto.dto.request.DetalleVentaRequestDTO;
import com.s1.gestion_producto.dto.response.DetalleVentaResponseDTO;

import java.util.List;

public interface DetalleVentaService {
    DetalleVentaResponseDTO guardarDetalle(DetalleVentaRequestDTO dto);
    DetalleVentaResponseDTO actualizarDetalle(DetalleVentaRequestDTO dto, Long id);
    List<DetalleVentaResponseDTO> buscarPorIdProducto(Long id);
    void eliminarDetalle(Long id);
    List<DetalleVentaResponseDTO> listarDetalle();
    DetalleVentaResponseDTO buscarPorId(Long id);
}
