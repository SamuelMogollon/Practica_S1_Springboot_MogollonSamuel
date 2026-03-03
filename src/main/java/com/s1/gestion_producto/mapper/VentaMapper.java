package com.s1.gestion_producto.mapper;

import com.s1.gestion_producto.dto.request.VentaRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.model.Producto;
import com.s1.gestion_producto.model.Venta;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class VentaMapper {
    public VentaResponseDTO entidadADTO(Venta venta) {
        if (venta == null) return null;
        Producto p = venta.getProducto();
        ProductoResponseDTO productoDTO = null;

        if (p != null) {
            productoDTO = new ProductoResponseDTO(
                    p.getId(),
                    p.getNombre(),
                    p.getDescripcion(),
                    p.getPrecio(),
                    p.getActivo()
            );
        }
        return new VentaResponseDTO(
                venta.getId(),
                venta.getFecha(),
                venta.getTotal(),
                venta.getEstado(),
                productoDTO
        );
    }
    public static Venta DTOAEntidad(VentaRequestDTO dto, Producto p){
        if (dto == null) return null;
        Venta ve = new Venta();
        ve.setFecha(LocalDate.now());
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