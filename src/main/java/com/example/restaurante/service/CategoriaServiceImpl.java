package com.example.restaurante.service;

import com.example.restaurante.dtos.CategoriaCreateDTO;
import com.example.restaurante.dtos.CategoriaDTO;
import com.example.restaurante.dtos.CategoriaUpdateDTO;
import com.example.restaurante.mappers.CategoriaMapper;
import com.example.restaurante.model.Categoria;
import com.example.restaurante.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{


    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<CategoriaDTO> listarCategorias() {
        return CategoriaMapper.instancia.listaCategoriaAListaCategoriaDTO(categoriaRepository.findAll());
    }

    @Override
    public CategoriaDTO obtenerCategoriaPorId(Integer id) {
        Optional<Categoria> categoria=categoriaRepository.findById(id);
        return categoria.map(CategoriaMapper.instancia::categoriaACategoriaDTO).orElse(null);
    }

    @Override
    public CategoriaDTO registrarCategoria(CategoriaCreateDTO categoriaCreateDTO) {
        Categoria categoria=CategoriaMapper.instancia.categoriaCreateDTOACategoria(categoriaCreateDTO);
        Categoria respuestaEntity=categoriaRepository.save(categoria);
        return CategoriaMapper.instancia.categoriaACategoriaDTO(respuestaEntity);
    }

    @Override
    public CategoriaDTO actualizarCategoria(CategoriaUpdateDTO categoriaUpdateDTO) {
        Categoria categoria=CategoriaMapper.instancia.categoriaUpdateDTOACategoria(categoriaUpdateDTO);
        Categoria respuestaEntity=categoriaRepository.save(categoria);
        return CategoriaMapper.instancia.categoriaACategoriaDTO(respuestaEntity);
    }

    @Override
    public String eliminarCategoria(Integer id) {
        Optional<Categoria> categoriaOptional=categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()){
            categoriaRepository.delete(categoriaOptional.get());
            return "Registro Eliminado";
        }else {
            return "No se pudo eliminar";
        }
    }
}
