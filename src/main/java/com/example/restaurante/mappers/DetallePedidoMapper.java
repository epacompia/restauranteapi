package com.example.restaurante.mappers;

import com.example.restaurante.dtos.DetallePedidoCreateDTO;
import com.example.restaurante.dtos.DetallePedidoDTO;
import com.example.restaurante.dtos.DetallePedidoUpdateDTO;
import com.example.restaurante.model.DetallePedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DetallePedidoMapper {
    
    DetallePedidoMapper instancia= Mappers.getMapper(DetallePedidoMapper.class);

    @Mapping(target ="producto", source = "producto")
    DetallePedidoDTO detallePedidoADetallePedidoDTO(DetallePedido detallePedido);

    @Mapping(target = "producto", source = "producto")
    DetallePedido detallePedidoDTOADetallePedido(DetallePedidoDTO detallePedidoDTO);

    @Mapping(target = "producto", source = "producto")
    DetallePedido detallePedidoCreateDTOADetallePedido(DetallePedidoCreateDTO detallePedidoCreateDTO);

    @Mapping(target = "producto", source = "producto")
    DetallePedido detallePedidoUpdateDTOADetallePedido(DetallePedidoUpdateDTO detallePedidoUpdateDTO);

    @Mapping(target = "producto", source = "producto")
    List<DetallePedidoDTO> listaDetallePedidoAListaDetallePedidoDTO (List<DetallePedido> listaDetallePedido);
}
