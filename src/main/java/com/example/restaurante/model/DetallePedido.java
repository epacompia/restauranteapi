package com.example.restaurante.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "detallepedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cantidad;
    private BigDecimal precio;
    @ManyToOne()
    @JoinColumn(name = "pedidoid")
    private Pedido pedido;
    @ManyToOne()
    @JoinColumn(name = "productoid")
    private Producto producto;
}
