package com.example.restaurante.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer estado;
    private CategoriaDTO categoria;

}
