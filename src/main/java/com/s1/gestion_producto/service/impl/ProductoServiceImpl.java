package com.s1.gestion_producto.service.impl;

import com.s1.gestion_producto.dto.request.ProductoRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.mapper.ProductoMapper;
import com.s1.gestion_producto.model.Producto;
import com.s1.gestion_producto.repository.ProductoRepository;
import com.s1.gestion_producto.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    private final ProductoMapper productoMapper;
    private final ProductoRepository productoRepository;
    @Override
    public ProductoResponseDTO guardarProducto(ProductoRequestDTO dto) {
        Producto p = ProductoMapper.DTOAEntidad(dto);
        Producto p_insertado = productoRepository.save(p);
        return productoMapper.entidadADTO(p_insertado);
    }

    @Override
    public ProductoResponseDTO actualizarProducto(ProductoRequestDTO dto, Long id) {
        Producto p=productoRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicho producto"));
        productoMapper.actualizarEntidadDesdeDTO(p,dto);
        Producto p_actualizado=productoRepository.save(p);
        return productoMapper.entidadADTO(p_actualizado);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto p = productoRepository.findById(id).orElseThrow(()->new RuntimeException("No existe dicho producto"));
        productoRepository.deleteById(id);
    }

    @Override
    public List<ProductoResponseDTO> buscarTodos() {
        List<Producto> productos=productoRepository.findAll();
        return productos.stream().map(productoMapper::entidadADTO).toList();
    }

    @Override
    public List<ProductoResponseDTO> buscarNombre(String nombre) {
        List<Producto> productos = (List<Producto>) productoRepository.findByNombreIgnoreCase(nombre);
        return productos.stream().map(productoMapper::entidadADTO).toList();
    }

    @Override
    public boolean buscarExisteNombre(String nombre) {
        return productoRepository.existsByNombre(nombre);
    }

    @Override
    public Long contarNombreRepetido(String nombre) {
        return productoRepository.countByNombre(nombre);
    }

    @Override
    public ProductoResponseDTO buscarId(Long Id) {
        Producto p=productoRepository.findById(Id).orElseThrow(()->new RuntimeException("No existe dicho producto"));
        return productoMapper.entidadADTO(p);
    }
}
