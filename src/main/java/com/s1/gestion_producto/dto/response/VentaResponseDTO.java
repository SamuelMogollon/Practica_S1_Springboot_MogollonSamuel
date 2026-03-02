package com.s1.gestion_producto.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VentaResponseDTO(
        Long id,
        LocalDate fecha,
        BigDecimal total,
        String estado,
        ProductoResponseDTO producto
) {}
