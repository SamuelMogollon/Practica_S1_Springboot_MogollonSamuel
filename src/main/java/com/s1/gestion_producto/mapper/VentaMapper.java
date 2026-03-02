package com.s1.gestion_producto.mapper;

import com.s1.gestion_producto.dto.request.VentaRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.model.Producto;
import com.s1.gestion_producto.model.Venta;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {
    public VentaResponseDTO entidadADTO(Venta venta) {

        return new VentaResponseDTO(
                venta.getId(),
                venta.getFecha(),
                venta.getTotal(),
                venta.getEstado(),
                null
        );
    }
    public static Venta DTOAEntidad(VentaRequestDTO dto, Producto p){
        if (dto == null) return null;
        Venta ve = new Venta();
        ve.setTotal(dto.total());
        ve.setMetodoPago(dto.metodoPago());
        ve.setEstado(dto.estado());
        ve.setProducto(p);
        return ve;
    }
    public void actualizarEntidadDesdeDTO(Venta venta, VentaRequestDTO dto, Producto p){
        if (venta == null || dto == null) return;
        venta.setTotal(dto.total());
        venta.setMetodoPago(dto.metodoPago());
        venta.setEstado(dto.estado());
    }
    public VentaResponseDTO entidadADTO(Venta venta, ProductoResponseDTO productoDTO) {

        if (venta == null) return null;

        return new VentaResponseDTO(
                venta.getId(),
                venta.getFecha(),
                venta.getTotal(),
                venta.getEstado(),
                productoDTO
        );
    }
}
