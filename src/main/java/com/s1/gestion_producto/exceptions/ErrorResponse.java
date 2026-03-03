package com.s1.gestion_producto.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse
        (LocalDateTime timestamp, int status, String message, String errorCode) {
}
