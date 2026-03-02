package com.s1.gestion_producto.service.impl;

import com.s1.gestion_producto.dto.request.DetalleVentaRequestDTO;
import com.s1.gestion_producto.dto.response.DetalleVentaResponseDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.mapper.DetalleVentaMapper;
import com.s1.gestion_producto.mapper.ProductoMapper;
import com.s1.gestion_producto.mapper.VentaMapper;
import com.s1.gestion_producto.model.DetalleVenta;
import com.s1.gestion_producto.model.Producto;
import com.s1.gestion_producto.model.Venta;
import com.s1.gestion_producto.repository.DetalleVentaRepository;
import com.s1.gestion_producto.repository.ProductoRepository;
import com.s1.gestion_producto.repository.VentaRepository;
import com.s1.gestion_producto.service.DetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleVentaServiceImpl implements DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;
    private final DetalleVentaMapper detalleVentaMapper;
    private final VentaRepository ventaRepository;
    private final VentaMapper ventaMapper;
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public DetalleVentaResponseDTO guardarDetalle(DetalleVentaRequestDTO dto) {

        Venta ve = ventaRepository.findById(dto.idVenta())
                .orElseThrow(() -> new RuntimeException("Error, no existe dicha venta"));

        Producto p = productoRepository.findById(dto.idProducto())
                .orElseThrow(() -> new RuntimeException("Error, no existe dicho producto"));

        DetalleVenta dv = detalleVentaMapper.DTOAEntidad(dto, ve, p);

        DetalleVenta dvInsertada = detalleVentaRepository.save(dv);

        return detalleVentaMapper.entidadADTO(dvInsertada);
    }

    @Override
    public DetalleVentaResponseDTO actualizarDetalle(
            DetalleVentaRequestDTO dto,
            Long id) {

        DetalleVenta dv = detalleVentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error, no existe dicho detalle"));

        Venta ve = ventaRepository.findById(dto.idVenta())
                .orElseThrow(() -> new RuntimeException("Error, no existe dicha venta"));

        Producto p = productoRepository.findById(dto.idProducto())
                .orElseThrow(() -> new RuntimeException("Error, no existe dicho producto"));

        detalleVentaMapper.actualizarEntidadDesdeDTO(dv, dto, ve, p);

        DetalleVenta actualizada = detalleVentaRepository.save(dv);

        return detalleVentaMapper.entidadADTO(actualizada);
    }

    @Override
    public List<DetalleVentaResponseDTO> buscarPorIdProducto(Long id) {

        productoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("No existe dicho producto"));

        return detalleVentaRepository.findByProductoId(id)
                .stream()
                .map(dv -> detalleVentaMapper.entidadADTO(dv))
                .toList();
    }

    @Override
    public void eliminarDetalle(Long id) {

        DetalleVenta dv = detalleVentaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("No existe el detalle de venta"));

        detalleVentaRepository.delete(dv);
    }

    @Override
    public List<DetalleVentaResponseDTO> listarDetalle() {
        return detalleVentaRepository.findAll()
                .stream()
                .map(detalleVentaMapper::entidadADTO)
                .toList();
    }

    @Override
    public DetalleVentaResponseDTO buscarPorId(Long id) {
        DetalleVenta dv = detalleVentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe dicho detalle"));

        Venta venta = ventaRepository.findById(dv.getVenta().getId())
                .orElseThrow(() -> new RuntimeException("No existe dicha venta"));

        Producto producto = productoRepository.findById(dv.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("No existe dicho producto"));

        VentaResponseDTO ventaDTO = ventaMapper.entidadADTO(venta);
        ProductoResponseDTO productoDTO = productoMapper.entidadADTO(producto);

        return detalleVentaMapper.entidadADTO(dv, ventaDTO, productoDTO);
    }
}
