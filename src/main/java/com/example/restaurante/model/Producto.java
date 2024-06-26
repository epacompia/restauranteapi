package com.example.restaurante.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "productos")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer estado;
    @ManyToOne()
    @JoinColumn(name = "categoriaid")
    private Categoria categoria;

}
