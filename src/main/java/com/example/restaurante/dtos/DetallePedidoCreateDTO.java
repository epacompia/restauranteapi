package com.example.restaurante.dtos;

import lombok.Data;

@Data
public class DetallePedidoCreateDTO {

    private int cantidad;
    private double precio;
    private double total;
    private ProductoDTO producto;

}
