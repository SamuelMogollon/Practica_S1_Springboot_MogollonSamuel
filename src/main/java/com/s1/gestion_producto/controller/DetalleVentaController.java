package com.s1.gestion_producto.controller;

import com.s1.gestion_producto.dto.request.DetalleVentaRequestDTO;
import com.s1.gestion_producto.dto.response.DetalleVentaResponseDTO;
import com.s1.gestion_producto.service.impl.DetalleVentaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Gestion de DetalleVenta", description = "gestiona los datos de la tabla detalleVenta")

@RestController
@RequestMapping("/api/detalleVenta")
@RequiredArgsConstructor
public class DetalleVentaController {
    private final DetalleVentaServiceImpl detalleVentaServiceImpl;

    @Operation(summary= "GuardarDetalleVenta", description = "aqui es donde se crea el nuevo detalleVenta")
    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Usuario creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"),
                    @ApiResponse(responseCode = "401",
                            description = "No autorizado / token faltante o inválido"),
                    @ApiResponse(responseCode = "403",
                            description = "Prohibido / usuario no tiene permisos"),
                    @ApiResponse(responseCode = "404",
                            description = "Recurso no encontrado / endpoint incorrecto"),
                    @ApiResponse(responseCode = "409",
                            description = "Conflicto / el usuario ya existe"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            }
    )
    public ResponseEntity<DetalleVentaResponseDTO> guardar(@RequestBody DetalleVentaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentaServiceImpl.guardarDetalle(dto));
    }

    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Usuario creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"),
                    @ApiResponse(responseCode = "401",
                            description = "No autorizado / token faltante o inválido"),
                    @ApiResponse(responseCode = "403",
                            description = "Prohibido / usuario no tiene permisos"),
                    @ApiResponse(responseCode = "404",
                            description = "Recurso no encontrado / endpoint incorrecto"),
                    @ApiResponse(responseCode = "409",
                            description = "Conflicto / el usuario ya existe"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            }
    )
    public ResponseEntity<DetalleVentaResponseDTO> actualizar(
            @RequestBody DetalleVentaRequestDTO dto,
            @Parameter(description = "aqui es donde se actualiza un detalle de venta", example = "1")
            @PathVariable Long id){
        return ResponseEntity.ok().body(detalleVentaServiceImpl.actualizarDetalle(dto, id));
    }

    @Operation(summary= "ListarDetalleVenta", description = "aqui es donde se listan todos los detalles de las ventas")
    @GetMapping
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Usuario creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"),
                    @ApiResponse(responseCode = "401",
                            description = "No autorizado / token faltante o inválido"),
                    @ApiResponse(responseCode = "403",
                            description = "Prohibido / usuario no tiene permisos"),
                    @ApiResponse(responseCode = "404",
                            description = "Recurso no encontrado / endpoint incorrecto"),
                    @ApiResponse(responseCode = "409",
                            description = "Conflicto / el usuario ya existe"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            }
    )
    public ResponseEntity<List<DetalleVentaResponseDTO>>  listarTodos(){
        return ResponseEntity.ok().body(detalleVentaServiceImpl.listarDetalle());
    }

    @GetMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Usuario creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"),
                    @ApiResponse(responseCode = "401",
                            description = "No autorizado / token faltante o inválido"),
                    @ApiResponse(responseCode = "403",
                            description = "Prohibido / usuario no tiene permisos"),
                    @ApiResponse(responseCode = "404",
                            description = "Recurso no encontrado / endpoint incorrecto"),
                    @ApiResponse(responseCode = "409",
                            description = "Conflicto / el usuario ya existe"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            }
    )
    public ResponseEntity<DetalleVentaResponseDTO>  buscarId(
            @Parameter(description = "aqui es donde se actualiza un detalle de venta segun su id", example = "1")
            @PathVariable Long id){
        return ResponseEntity.ok().body(detalleVentaServiceImpl.buscarPorId(id));
    }
    @DeleteMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Usuario creado exitosamente"),
                    @ApiResponse(responseCode = "400",
                            description = "Datos no válidos / body mal estructurado"),
                    @ApiResponse(responseCode = "401",
                            description = "No autorizado / token faltante o inválido"),
                    @ApiResponse(responseCode = "403",
                            description = "Prohibido / usuario no tiene permisos"),
                    @ApiResponse(responseCode = "404",
                            description = "Recurso no encontrado / endpoint incorrecto"),
                    @ApiResponse(responseCode = "409",
                            description = "Conflicto / el usuario ya existe"),
                    @ApiResponse(responseCode = "500",
                            description = "Error interno del servidor")
            }
    )
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "aqui es donde se elimina un detalle de venta segun su id", example = "1")
            @PathVariable Long id){
        detalleVentaServiceImpl.eliminarDetalle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
