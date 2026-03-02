package com.s1.gestion_producto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "venta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(nullable = false)
    private BigDecimal total;
    @Column(name = "metodo_pago")
    private String metodoPago;
    @Column
    private String estado;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @OneToMany(mappedBy = "venta",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<DetalleVenta> detalleVenta;
}
