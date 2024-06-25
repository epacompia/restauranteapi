package com.example.restaurante.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoUsuarioUpdateDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
}
