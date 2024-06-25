package com.example.restaurante.service;

import com.example.restaurante.dtos.ProductoCreateDTO;
import com.example.restaurante.dtos.ProductoDTO;
import com.example.restaurante.dtos.ProductoUpdateDTO;

import java.util.List;

public interface ProductoService {
    List<ProductoDTO> listarProductos();
    ProductoDTO obtenerProductoPorId(Integer id);
    ProductoDTO registrarProducto(ProductoCreateDTO productoCreateDTO);
    ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO);
    String eliminarProducto(Integer id);
}
