package com.example.restaurante.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;


@Entity
@Table(name = "pedidos")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fecha;
    private String hora;
    private Double total;
    private Integer estado;
    @OneToMany(mappedBy = "pedido", cascade = { CascadeType.ALL, CascadeType.MERGE,
            CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DetallePedido> detallePedido;

    @ManyToOne()
    @JoinColumn(name = "usuarioid")
    private Usuario usuario;


    public Double getTotal() {
        double totalPedido = 0.00;
        for(DetallePedido detalle : detallePedido) {
            totalPedido += detalle.getTotal();
        }
        return totalPedido;
    }
}
