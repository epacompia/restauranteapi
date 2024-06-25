package com.example.restaurante.mappers;

import com.example.restaurante.dtos.PedidoCreateDTO;
import com.example.restaurante.dtos.PedidoDTO;
import com.example.restaurante.dtos.PedidoUpdateDTO;
import com.example.restaurante.model.Pedido;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoMapper {
    
    PedidoMapper instancia= Mappers.getMapper(PedidoMapper.class);

    @Mapping(target = "usuario", source = "usuario")
    PedidoDTO pedidoAPedidoDTO(Pedido pedido);

    @Mapping(target = "usuario", source = "usuario")
    Pedido pedidoDTOAPedido(PedidoDTO pedidoDTO);

    @Mapping(target = "usuario", source = "usuario")
    Pedido pedidoCreateDTOAPedido(PedidoCreateDTO pedidoCreateDTO);

    @Mapping(target = "usuario", source = "usuario")
    Pedido pedidoUpdateDTOAPedido(PedidoUpdateDTO pedidoUpdateDTO);

    @Mapping(target = "usuario", source = "usuario")
    List<PedidoDTO> listaPedidoAListaPedidoDTO (List<Pedido> listaPedido);
}
