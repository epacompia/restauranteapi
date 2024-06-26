package com.example.restaurante.dtos;

import lombok.Data;

@Data
public class DetallePedidoDTO {

    private Integer id;
    private int cantidad;
    private double precio;
    private double total;
    private PedidoDTO pedido;
    private ProductoDTO producto;

}
