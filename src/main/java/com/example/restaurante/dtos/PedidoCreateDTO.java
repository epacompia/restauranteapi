package com.example.restaurante.dtos;

import lombok.Data;

@Data
public class PedidoCreateDTO {

    private String fecha;
    private String hora;
    private Double total;
    private Integer estado;
    private UsuarioDTO usuario;


}
