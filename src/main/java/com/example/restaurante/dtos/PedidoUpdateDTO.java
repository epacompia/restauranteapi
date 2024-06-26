package com.example.restaurante.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PedidoUpdateDTO {

    private Integer id;
    private String fecha;
    private String hora;
    private Double total;
    private Integer estado;
    private List<DetallePedidoDTO> detallePedido;
    private UsuarioDTO usuario;


}
