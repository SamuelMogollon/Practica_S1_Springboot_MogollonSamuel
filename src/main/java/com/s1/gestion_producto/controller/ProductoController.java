package com.s1.gestion_producto.controller;

import com.s1.gestion_producto.dto.request.ProductoRequestDTO;
import com.s1.gestion_producto.dto.response.ProductoResponseDTO;
import com.s1.gestion_producto.service.ProductoService;
import com.s1.gestion_producto.service.impl.ProductoServiceImpl;
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

@Tag(name="Gestion de Producto", description = "gestiona los datos de los productos")

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoServiceImpl productoServiceImpl;


    @Operation(summary= "GuardarProducto", description = "aqui es donde se crea el nuevo producto")
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
    public ResponseEntity<ProductoResponseDTO> guardar(@RequestBody ProductoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoServiceImpl.guardarProducto(dto));
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
    public ResponseEntity<ProductoResponseDTO> actualizar(
            @RequestBody ProductoRequestDTO dto,@Parameter(description = "aqui es donde se actualiza un producto", example = "1")
            @PathVariable Long id){
        return ResponseEntity.ok().body(productoServiceImpl.actualizarProducto(dto, id));
    }

    @Operation(summary= "ListarPrducto", description = "aqui es donde se listan todos los productos")
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
    public ResponseEntity<List<ProductoResponseDTO>>  listarTodos(){
        return ResponseEntity.ok().body(productoServiceImpl.buscarTodos());
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
    public ResponseEntity<ProductoResponseDTO>  buscarId(
            @Parameter(description = "aqui es donde se actualiza un producto segun su id", example = "1")
            @PathVariable Long id){
        return ResponseEntity.ok().body(productoServiceImpl.buscarId(id));
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
            @Parameter(description = "aqui es donde se elimina un producto segun su id", example = "1")
            @PathVariable Long id){
        productoServiceImpl.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
