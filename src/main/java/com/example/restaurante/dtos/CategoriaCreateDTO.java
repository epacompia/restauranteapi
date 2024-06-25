package com.example.restaurante.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CategoriaCreateDTO {
    private String nombre;
    private Integer estado;
}
