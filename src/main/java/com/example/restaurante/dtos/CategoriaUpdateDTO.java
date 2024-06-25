package com.example.restaurante.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaUpdateDTO {
    private Integer id;
    private String nombre;
    private Integer estado;
}
