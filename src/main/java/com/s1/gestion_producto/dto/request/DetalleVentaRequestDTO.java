package com.s1.gestion_producto.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DetalleVentaRequestDTO(@NotNull(message = "El subtotal es obligatorio.")
                                     BigDecimal subtotal,
                                     @NotNull(message = "La cantidad es obligatoria.")
                                     @Min(value = 1, message = "La cantidad debe ser al menos 1")
                                     Integer cantidad,
                                     Long idVenta,
                                     Long idProducto) {
}
