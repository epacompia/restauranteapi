package com.example.restaurante.controller;

import com.example.restaurante.dtos.ProductoCreateDTO;
import com.example.restaurante.dtos.ProductoDTO;
import com.example.restaurante.dtos.ProductoUpdateDTO;
import com.example.restaurante.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @Operation(summary = "Endpoint que permite listar las Productos",
            description = "Endpoint que permite listar las Productos")
    @GetMapping("productos")
    public ResponseEntity<List<ProductoDTO>> listarProductos(){
        return new ResponseEntity<>(productoService.listarProductos(), HttpStatus.OK);
    }

    @GetMapping("/productos/{productoId}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable("productoId") Integer productoId){
        return new ResponseEntity<>(productoService.obtenerProductoPorId(productoId), HttpStatus.OK);
    }

    @PostMapping("productos")
    public ResponseEntity<ProductoDTO> registrarProducto(@RequestBody ProductoCreateDTO productoCreateDTO){
        return new ResponseEntity<>(productoService.registrarProducto(productoCreateDTO), HttpStatus.OK);
    }

    @PutMapping("productos")
    public ResponseEntity<ProductoDTO> actualizarProducto(@RequestBody ProductoUpdateDTO productoUpdateDTO) {
        return new ResponseEntity<>(productoService.actualizarProducto(productoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/productos/{productoId}")
    public ResponseEntity<String> eliminarProducto(@PathVariable("productoId") Integer productoId){
        return new ResponseEntity<>(productoService.eliminarProducto(productoId), HttpStatus.OK);
    }


}
