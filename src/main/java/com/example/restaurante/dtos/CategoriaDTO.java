package com.example.restaurante.dtos;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoriaDTO {
    private Integer id;
    private String nombre;
    private Integer estado;
}
