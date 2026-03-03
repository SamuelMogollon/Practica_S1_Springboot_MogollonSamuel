package com.s1.gestion_producto.service.impl;

import com.s1.gestion_producto.dto.request.VentaRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.mapper.ProductoMapper;
import com.s1.gestion_producto.mapper.VentaMapper;
import com.s1.gestion_producto.model.Producto;
import com.s1.gestion_producto.model.Venta;
import com.s1.gestion_producto.repository.ProductoRepository;
import com.s1.gestion_producto.repository.VentaRepository;
import com.s1.gestion_producto.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {
    private final VentaMapper ventaMapper;
    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public VentaResponseDTO guardarVenta(VentaRequestDTO dto) {
        Producto p = productoRepository.findById(dto.idProducto()).orElseThrow(()->new RuntimeException("Error, no existe dicho producto"));
        Venta ve = ventaMapper.DTOAEntidad(dto, p);
        Venta ve_insertada = ventaRepository.save(ve);
        ProductoResponseDTO dtoProducto = productoMapper.entidadADTO(p);
        return ventaMapper.entidadADTO(ve_insertada,dtoProducto);
    }

    @Override
    public VentaResponseDTO actualizarVenta(VentaRequestDTO dto, Long id) {
        Venta ve=ventaRepository.findById(id).orElseThrow(()->new RuntimeException("Error, no existe dicha venta a actualizar"));
        Producto p= productoRepository.findById(dto.idProducto()).orElseThrow(()->new RuntimeException("Error, no existe dicho producto"));
        ventaMapper.actualizarEntidadDesdeDTO(ve, dto, p);
        Venta ve_actualizada=ventaRepository.save(ve);
        ProductoResponseDTO dtoProducto=productoMapper.entidadADTO(p);
        return ventaMapper.entidadADTO(ve_actualizada,dtoProducto);
    }

    @Override
    public void eliminarVenta(Long id) {

        Venta venta = ventaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("No existe la venta"));

        ventaRepository.delete(venta);
    }

    @Override
    public List<VentaResponseDTO> buscarTodos() {
        return ventaRepository.findAll().stream().map(dato-> ventaMapper.entidadADTO(dato, productoMapper.entidadADTO(productoRepository.findById(dato.getProducto().getId()).orElseThrow(()->new RuntimeException("No existe dicho producto"))))).toList();

    }

    @Override
    public VentaResponseDTO buscarId(Long Id) {
        Venta ve = ventaRepository.findById(Id).orElseThrow(()->new RuntimeException("No existe dicha venta"));
        Producto producto = productoRepository.findById(ve.getProducto().getId()).orElseThrow(() -> new RuntimeException("No existe dicho producto"));
        ProductoResponseDTO productoR = productoMapper.entidadADTO(producto);
        return ventaMapper.entidadADTO(ve, productoR);
    }

    @Override
    public boolean buscarExisteId(Long id) {
        return ventaRepository.existsById(id);
    }

    @Override
    public Long countByFecha(LocalDate fecha) {
        return ventaRepository.countByFecha(fecha);
    }
}
