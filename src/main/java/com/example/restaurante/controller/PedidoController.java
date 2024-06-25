package com.example.restaurante.controller;

import com.example.restaurante.dtos.PedidoCreateDTO;
import com.example.restaurante.dtos.PedidoDTO;
import com.example.restaurante.dtos.PedidoUpdateDTO;
import com.example.restaurante.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @Operation(summary = "Endpoint que permite listar las Pedidos",
            description = "Endpoint que permite listar las Pedidos")
    @GetMapping("pedidos")
    public ResponseEntity<List<PedidoDTO>> listarPedidos(){
        return new ResponseEntity<>(pedidoService.listarPedidos(), HttpStatus.OK);
    }

    @GetMapping("/pedidos/{pedidoId}")
    public ResponseEntity<PedidoDTO> obtenerPedidoPorId(@PathVariable("pedidoId") Integer pedidoId){
        return new ResponseEntity<>(pedidoService.obtenerPedidoPorId(pedidoId), HttpStatus.OK);
    }

    @PostMapping("pedidos")
    public ResponseEntity<PedidoDTO> registrarPedido(@RequestBody PedidoCreateDTO pedidoCreateDTO){
        return new ResponseEntity<>(pedidoService.registrarPedido(pedidoCreateDTO), HttpStatus.OK);
    }

    @PutMapping("pedidos")
    public ResponseEntity<PedidoDTO> actualizarPedido(@RequestBody PedidoUpdateDTO pedidoUpdateDTO) {
        return new ResponseEntity<>(pedidoService.actualizarPedido(pedidoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/pedidos/{pedidoId}")
    public ResponseEntity<String> eliminarPedido(@PathVariable("pedidoId") Integer pedidoId){
        return new ResponseEntity<>(pedidoService.eliminarPedido(pedidoId), HttpStatus.OK);
    }


}
