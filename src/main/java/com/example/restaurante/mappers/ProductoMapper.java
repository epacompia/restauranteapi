package com.example.restaurante.mappers;

import com.example.restaurante.dtos.ProductoCreateDTO;
import com.example.restaurante.dtos.ProductoDTO;
import com.example.restaurante.dtos.ProductoUpdateDTO;
import com.example.restaurante.model.Producto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {
    
    ProductoMapper instancia= Mappers.getMapper(ProductoMapper.class);

    @Mapping(target = "categoria", source = "categoria")
    ProductoDTO productoAProductoDTO(Producto producto);

    @Mapping(target = "categoria", source = "categoria")
    Producto productoDTOAProducto(ProductoDTO productoDTO);

    @Mapping(target = "categoria", source = "categoria")
    Producto productoCreateDTOAProducto(ProductoCreateDTO productoCreateDTO);

    @Mapping(target = "categoria", source = "categoria")
    Producto productoUpdateDTOAProducto(ProductoUpdateDTO productoUpdateDTO);

    @Mapping(target = "categoria", source = "categoria")
    List<ProductoDTO> listaProductoAListaProductoDTO (List<Producto> listaProducto);
}
