package com.example.restaurante.service;

import com.example.restaurante.dtos.ProductoCreateDTO;
import com.example.restaurante.dtos.ProductoDTO;
import com.example.restaurante.dtos.ProductoUpdateDTO;
import com.example.restaurante.mappers.ProductoMapper;
import com.example.restaurante.model.Producto;
import com.example.restaurante.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{


    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoDTO> listarProductos() {
        return ProductoMapper.instancia.listaProductoAListaProductoDTO(productoRepository.findAll());
    }

    @Override
    public ProductoDTO obtenerProductoPorId(Integer id) {
        Optional<Producto> producto=productoRepository.findById(id);
        return producto.map(ProductoMapper.instancia::productoAProductoDTO).orElse(null);
    }

    @Override
    public ProductoDTO registrarProducto(ProductoCreateDTO productoCreateDTO) {
        Producto producto=ProductoMapper.instancia.productoCreateDTOAProducto(productoCreateDTO);
        Producto respuestaEntity=productoRepository.save(producto);
        return ProductoMapper.instancia.productoAProductoDTO(respuestaEntity);
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoUpdateDTO productoUpdateDTO) {
        Producto producto=ProductoMapper.instancia.productoUpdateDTOAProducto(productoUpdateDTO);
        Producto respuestaEntity=productoRepository.save(producto);
        return ProductoMapper.instancia.productoAProductoDTO(respuestaEntity);
    }

    @Override
    public String eliminarProducto(Integer id) {
        Optional<Producto> productoOptional=productoRepository.findById(id);
        if (productoOptional.isPresent()){
            productoRepository.delete(productoOptional.get());
            return "Registro Eliminado";
        }else {
            return "No se pudo eliminar";
        }
    }
}
