package com.example.restaurante.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detallepedidos")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int cantidad;
    private double precio;
    private double total;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pedidoid", nullable = false)
    private Pedido pedido;
    @ManyToOne()
    @JoinColumn(name = "productoid")
    private Producto producto;


    public double getTotal() {
        return cantidad * precio;
    }
}
