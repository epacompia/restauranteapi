package com.example.restaurante.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PedidoCreateDTO {

    private String fecha;
    private String hora;
    private Double total;
    private Integer estado;
    private List<DetallePedidoCreateDTO> detallePedido;
    private UsuarioDTO usuario;

}
