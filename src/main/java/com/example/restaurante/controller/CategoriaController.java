package com.example.restaurante.controller;

import com.example.restaurante.dtos.CategoriaCreateDTO;
import com.example.restaurante.dtos.CategoriaDTO;
import com.example.restaurante.dtos.CategoriaUpdateDTO;
import com.example.restaurante.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @Operation(summary = "Endpoint que permite listar las Categorias",
            description = "Endpoint que permite listar las Categorias")
    @GetMapping("categorias")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias(){
        return new ResponseEntity<>(categoriaService.listarCategorias(), HttpStatus.OK);
    }

    @GetMapping("/categorias/{categoriaId}")
    public ResponseEntity<CategoriaDTO> obtenerCategoriaPorId(@PathVariable("categoriaId") Integer categoriaId){
        return new ResponseEntity<>(categoriaService.obtenerCategoriaPorId(categoriaId), HttpStatus.OK);
    }

    @PostMapping("categorias")
    public ResponseEntity<CategoriaDTO> registrarCategoria(@RequestBody CategoriaCreateDTO categoriaCreateDTO){
        return new ResponseEntity<>(categoriaService.registrarCategoria(categoriaCreateDTO), HttpStatus.OK);
    }

    @PutMapping("categorias")
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@RequestBody CategoriaUpdateDTO categoriaUpdateDTO) {
        return new ResponseEntity<>(categoriaService.actualizarCategoria(categoriaUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/categorias/{categoriaId}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable("categoriaId") Integer categoriaId){
        return new ResponseEntity<>(categoriaService.eliminarCategoria(categoriaId), HttpStatus.OK);
    }


}
