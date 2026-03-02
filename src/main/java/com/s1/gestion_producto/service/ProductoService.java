package com.s1.gestion_producto.service;

import com.s1.gestion_producto.dto.request.ProductoRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;

import java.util.List;

public interface ProductoService {
    ProductoResponseDTO guardarProducto(ProductoRequestDTO dto);
    ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id);
    void eliminarProducto(Long id);
    List<ProductoResponseDTO> buscarTodos();
    List<ProductoResponseDTO> buscarNombre(String nombre);
    boolean buscarExisteNombre(String nombre);
    Long contarNombreRepetido(String nombre);
    ProductoResponseDTO buscarId(Long Id);
}
