package com.s1.gestion_producto.dto.response;

import java.math.BigDecimal;

public record DetalleVentaResponseDTO(Long id, Integer subtotal, BigDecimal cantidad, VentaResponseDTO venta,
                                      ProductoResponseDTO productoDTO) {
}
