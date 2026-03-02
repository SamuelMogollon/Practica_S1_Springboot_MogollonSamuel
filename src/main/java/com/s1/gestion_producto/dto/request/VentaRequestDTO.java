package com.s1.gestion_producto.dto.request;

import com.s1.gestion_producto.model.Producto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record VentaRequestDTO(@NotNull(message = "El total es obligatorio.")


                              @DecimalMin(value = "0.0", inclusive = false,
                                      message = "El total debe ser mayor que 0")
                              BigDecimal total,

                              @NotBlank(message = "El método de pago no puede estar vacío.")
                              @Size(max = 50, message = "El método de pago no puede superar 50 caracteres")
                              String metodoPago,

                              @NotBlank(message = "El estado no puede estar vacío.")
                              @Size(max = 50, message = "El estado no puede superar 50 caracteres")
                              String estado,
                              Long productoId) {
}
