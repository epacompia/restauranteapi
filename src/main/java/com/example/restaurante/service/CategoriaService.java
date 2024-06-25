package com.example.restaurante.service;

import com.example.restaurante.dtos.CategoriaCreateDTO;
import com.example.restaurante.dtos.CategoriaDTO;
import com.example.restaurante.dtos.CategoriaUpdateDTO;

import java.util.List;

public interface CategoriaService {
    List<CategoriaDTO> listarCategorias();
    CategoriaDTO obtenerCategoriaPorId(Integer id);
    CategoriaDTO registrarCategoria(CategoriaCreateDTO categoriaCreateDTO);
    CategoriaDTO actualizarCategoria(CategoriaUpdateDTO categoriaUpdateDTO);
    String eliminarCategoria(Integer id);
}
