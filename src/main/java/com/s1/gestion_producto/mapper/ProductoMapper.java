package com.s1.gestion_producto.mapper;

import com.s1.gestion_producto.dto.request.ProductoRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    public ProductoResponseDTO entidadADTO(Producto producto) {
        if (producto == null) return null;
        return new ProductoResponseDTO(
                producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), producto.getActivo()
        );
    }
    public static Producto DTOAEntidad(ProductoRequestDTO dto){
        if(dto == null) return null;
        Producto p = new Producto();
        p.setNombre(dto.nombre());
        p.setDescripcion(dto.descripcion());
        p.setMarca(dto.marca());
        p.setCategoria(dto.categoria());
        p.setPrecio(dto.precio());
        p.setStock(dto.stock());
        p.setActivo(dto.activo() != null ? dto.activo() : true); // por defecto true si viene null
        return p;
    }
    public void actualizarEntidadDesdeDTO(Producto producto, ProductoRequestDTO dto){
        if(producto == null || dto == null) return;

        producto.setNombre(dto.nombre());
        producto.setDescripcion(dto.descripcion());
        producto.setMarca(dto.marca());
        producto.setCategoria(dto.categoria());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
        producto.setActivo(dto.activo() != null ? dto.activo() : producto.getActivo());
    }
}
