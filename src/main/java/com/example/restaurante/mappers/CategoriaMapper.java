package com.example.restaurante.mappers;

import com.example.restaurante.dtos.CategoriaCreateDTO;
import com.example.restaurante.dtos.CategoriaDTO;
import com.example.restaurante.dtos.CategoriaUpdateDTO;
import com.example.restaurante.model.Categoria;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoriaMapper {
    CategoriaMapper instancia= Mappers.getMapper(CategoriaMapper.class);
    CategoriaDTO categoriaACategoriaDTO(Categoria categoria);
    Categoria categoriaDTOACategoria(CategoriaDTO categoriaDTO);
    Categoria categoriaCreateDTOACategoria(CategoriaCreateDTO categoriaCreateDTO);
    Categoria categoriaUpdateDTOACategoria(CategoriaUpdateDTO categoriaUpdateDTO);
    List<CategoriaDTO> listaCategoriaAListaCategoriaDTO (List<Categoria> listaCategoria);
}
