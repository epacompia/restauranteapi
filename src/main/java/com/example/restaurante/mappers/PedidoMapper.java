package com.example.restaurante.mappers;

import com.example.restaurante.dtos.*;
import com.example.restaurante.model.DetallePedido;
import com.example.restaurante.model.Pedido;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoMapper {
    
    PedidoMapper instancia= Mappers.getMapper(PedidoMapper.class);

    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "detallePedido", source = "detallePedido", qualifiedByName = "mapDetallePedidoToDetallePedidoDTO")
    PedidoDTO pedidoAPedidoDTO(Pedido pedido);

    @Named("mapDetallePedidoToDetallePedidoDTO")
    default DetallePedidoDTO mapDetallePedidoToDetallePedidoDTO(DetallePedido detallePedido){
        DetallePedidoDTO detallePedidoDTO = new DetallePedidoDTO();
        detallePedidoDTO.setId(detallePedido.getId());
        detallePedidoDTO.setCantidad(detallePedido.getCantidad());
        detallePedidoDTO.setPrecio(detallePedido.getPrecio());
        //detallePedidoDTO.setPedido(PedidoMapper.instancia.pedidoAPedidoDTO(detallePedido.getPedido()));
        detallePedidoDTO.setProducto(ProductoMapper.instancia.productoAProductoDTO(detallePedido.getProducto()));
        detallePedidoDTO.setTotal(detallePedido.getTotal());
        return detallePedidoDTO;
    }


    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "detallePedido", source = "detallePedido")
    Pedido pedidoDTOAPedido(PedidoDTO pedidoDTO);

    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "detallePedido", source = "detallePedido", qualifiedByName = "mapDetallePedidoCreateDTOToDetallePedido")
    Pedido pedidoCreateDTOAPedido(PedidoCreateDTO pedidoCreateDTO);

    @Named("mapDetallePedidoCreateDTOToDetallePedido")
    default DetallePedido mapDetallePedidoCreateDTOToDetallePedido(DetallePedidoCreateDTO detallePedidoDTO){
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setCantidad(detallePedidoDTO.getCantidad());
        detallePedido.setPrecio(detallePedidoDTO.getPrecio());
        detallePedido.setProducto(ProductoMapper.instancia.productoDTOAProducto(detallePedidoDTO.getProducto()));
        detallePedido.setTotal(detallePedidoDTO.getTotal());
        return detallePedido;
    }

    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "detallePedido", source = "detallePedido")
    Pedido pedidoUpdateDTOAPedido(PedidoUpdateDTO pedidoUpdateDTO);

    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "detallePedido", source = "detallePedido", qualifiedByName = "mapDetallePedidoToDetallePedidoDTO")
    List<PedidoDTO> listaPedidoAListaPedidoDTO (List<Pedido> listaPedido);
}
