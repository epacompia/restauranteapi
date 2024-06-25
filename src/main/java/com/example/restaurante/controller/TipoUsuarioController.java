package com.example.restaurante.controller;

import com.example.restaurante.dtos.*;
import com.example.restaurante.service.TipoUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;


    @Operation(summary = "Endpoint que permite listar los tipos usuarios",
            description = "Endpoint que permite listar los tiposusuarios")
    @GetMapping("tipoUsuarios")
    public ResponseEntity<List<TipoUsuarioDTO>> listarTiposUsuarios(){
        return new ResponseEntity<>(tipoUsuarioService.listarTipoUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/tipoUsuarios/{tipoUsuarioId}")
    public ResponseEntity<TipoUsuarioDTO> obtenerTipoUsuarioPorId(@PathVariable("tipoUsuarioId") Integer tipoUsuarioId){
        return new ResponseEntity<>(tipoUsuarioService.obtenerTipoUsuarioPorId(tipoUsuarioId), HttpStatus.OK);
    }

    @PostMapping("tipoUsuarios")
    public ResponseEntity<TipoUsuarioDTO> registrarTipoUsuario(@RequestBody TipoUsuarioCreateDTO tipoUsuarioCreateDTO){
        return new ResponseEntity<>(tipoUsuarioService.registrarTipoUsuario(tipoUsuarioCreateDTO), HttpStatus.OK);
    }

    @PutMapping("tipoUsuarios")
    public ResponseEntity<TipoUsuarioDTO> actualizarTipoUsuario(@RequestBody TipoUsuarioUpdateDTO tipoUsuarioUpdateDTO) {
        return new ResponseEntity<>(tipoUsuarioService.actualizarTipoUsuario(tipoUsuarioUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/tipoUsuarios/{tipoUsuarioId}")
    public ResponseEntity<String> eliminarTipoUsuario(@PathVariable("tipoUsuarioId") Integer tipoUsuarioId){
        return new ResponseEntity<>(tipoUsuarioService.eliminarTipoUsuario(tipoUsuarioId), HttpStatus.OK);
    }
}
