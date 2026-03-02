package com.s1.gestion_producto.dto.response;

import java.math.BigDecimal;

public record ProductoResponseDTO(Long id, String nombre, String descripcion, BigDecimal precio, Boolean activo) {

}
