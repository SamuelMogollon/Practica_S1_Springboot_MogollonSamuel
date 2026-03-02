package com.s1.gestion_producto.controller;

import com.s1.gestion_producto.dto.request.VentaRequestDTO;
import com.s1.gestion_producto.dto.response.VentaResponseDTO;
import com.s1.gestion_producto.service.impl.VentaServiceImpl;
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

@Tag(name="Gestion de Venta", description = "gestiona la venta")
@RestController
@RequestMapping("/api/venta")
@RequiredArgsConstructor
public class VentaController {
    private final VentaServiceImpl ventaServiceImpl;

    @Operation(summary= "GuardarVenta", description = "aqui es donde se crea la nueva venta")
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
    public ResponseEntity<VentaResponseDTO> guardar(@RequestBody VentaRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaServiceImpl.guardarVenta(dto));
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
    public ResponseEntity<VentaResponseDTO> actualizar(
            @RequestBody VentaRequestDTO dto,
            @Parameter(description = "aqui es donde se actualiza una venta", example = "1")
            @PathVariable Long id){
        return ResponseEntity.ok().body(ventaServiceImpl.actualizarVenta(dto, id));
    }

    @Operation(summary= "ListarVenta", description = "aqui es donde se listan todas las ventas")
    @GetMapping
    public ResponseEntity<List<VentaResponseDTO>>  listarTodos(){
        return ResponseEntity.ok().body(ventaServiceImpl.buscarTodos());
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
    public ResponseEntity<VentaResponseDTO>  buscarId(
            @Parameter(description = "aqui es donde se actualiza una venta segun su id", example = "1")
            @PathVariable Long id){
        return ResponseEntity.ok().body(ventaServiceImpl.buscarId(id));
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
            @Parameter(description = "aqui es donde se elimina una venta segun su id", example = "1")
            @PathVariable Long id){
        ventaServiceImpl.eliminarVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
