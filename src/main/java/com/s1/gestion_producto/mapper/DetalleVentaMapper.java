package com.s1.gestion_producto.mapper;

import com.s1.gestion_producto.dto.request.DetalleVentaRequestDTO;
import com.s1.gestion_producto.dto.response.DetalleVentaResponseDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.model.DetalleVenta;
import com.s1.gestion_producto.model.Producto;
import com.s1.gestion_producto.model.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DetalleVentaMapper {

    @Autowired
    private VentaMapper ventaMapper;

    @Autowired
    private ProductoMapper productoMapper;

    // DTO -> ENTIDAD
    public DetalleVenta DTOAEntidad(
            DetalleVentaRequestDTO dto,
            Venta venta,
            Producto producto) {

        DetalleVenta dv = new DetalleVenta();
        dv.setCantidad(dto.cantidad());
        dv.setSubtotal(dto.subtotal());
        dv.setVenta(venta);
        dv.setProducto(producto);

        return dv;
    }

    // UPDATE
    public void actualizarEntidadDesdeDTO(
            DetalleVenta dv,
            DetalleVentaRequestDTO dto,
            Venta ve,
            Producto p) {

        dv.setCantidad(dto.cantidad());
        dv.setSubtotal(dto.subtotal());
        dv.setVenta(ve);
        dv.setProducto(p);
    }

    // ENTIDAD -> DTO COMPLETO
    public DetalleVentaResponseDTO entidadADTO(
            DetalleVenta dv,
            VentaResponseDTO ventaDTO,
            ProductoResponseDTO productoDTO) {

        return new DetalleVentaResponseDTO(
                dv.getId(),
                dv.getCantidad(),
                dv.getSubtotal(),
                ventaDTO,
                productoDTO
        );
    }

    // ENTIDAD -> DTO AUTOMÁTICO
    public DetalleVentaResponseDTO entidadADTO(DetalleVenta dv) {

        VentaResponseDTO ventaDTO =
                ventaMapper.entidadADTO(dv.getVenta());

        ProductoResponseDTO productoDTO =
                productoMapper.entidadADTO(dv.getProducto());

        return entidadADTO(dv, ventaDTO, productoDTO);
    }
}