package com.example.restaurante.service;

import com.example.restaurante.dtos.PedidoCreateDTO;
import com.example.restaurante.dtos.PedidoDTO;
import com.example.restaurante.dtos.PedidoUpdateDTO;

import java.util.List;

public interface PedidoService {
    List<PedidoDTO> listarPedidos();
    PedidoDTO obtenerPedidoPorId(Integer id);
    PedidoDTO registrarPedido(PedidoCreateDTO pedidoCreateDTO);
    PedidoDTO actualizarPedido(PedidoUpdateDTO pedidoUpdateDTO);
    String eliminarPedido(Integer id);
}
