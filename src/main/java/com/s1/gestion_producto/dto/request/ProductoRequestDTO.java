package com.s1.gestion_producto.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductoRequestDTO(@NotBlank(message = "El nombre no puede estar vacío.")
                                  @Size(min = 2, max = 50,
                                          message = "El nombre debe tener entre 2 y 50 caracteres")
                                  String nombre,

                                 @NotBlank(message = "La descripción no puede estar vacía.")
                                  @Size(min = 2, max = 200,
                                          message = "La descripción debe tener entre 2 y 200 caracteres")
                                  String descripcion,

                                 @NotBlank(message = "La marca no puede estar vacía.")
                                  String marca,

                                 @NotBlank(message = "La categoría no puede estar vacía.")
                                  String categoria,

                                 @NotNull(message = "El precio es obligatorio.")
                                  @DecimalMin(value = "0.0", inclusive = false,
                                          message = "El precio debe ser mayor que 0")
                                 BigDecimal precio,

                                 @NotNull(message = "El stock es obligatorio.")
                                  @Min(value = 0, message = "El stock no puede ser negativo")
                                  Integer stock,
                                 Boolean activo) {
}
