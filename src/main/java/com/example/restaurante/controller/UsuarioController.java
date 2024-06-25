package com.example.restaurante.controller;

import com.example.restaurante.dtos.UsuarioCreateDTO;
import com.example.restaurante.dtos.UsuarioDTO;
import com.example.restaurante.dtos.UsuarioUpdateDTO;
import com.example.restaurante.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @Operation(summary = "Endpoint que permite listar las Usuarios",
            description = "Endpoint que permite listar las Usuarios")
    @GetMapping("usuarios")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        return new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable("usuarioId") Integer usuarioId){
        return new ResponseEntity<>(usuarioService.obtenerUsuarioPorId(usuarioId), HttpStatus.OK);
    }

    @PostMapping("usuarios")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioCreateDTO usuarioCreateDTO){
        return new ResponseEntity<>(usuarioService.registrarUsuario(usuarioCreateDTO), HttpStatus.OK);
    }

    @PutMapping("usuarios")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioUpdateDTO usuarioUpdateDTO) {
        return new ResponseEntity<>(usuarioService.actualizarUsuario(usuarioUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/{usuarioId}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable("usuarioId") Integer usuarioId){
        return new ResponseEntity<>(usuarioService.eliminarUsuario(usuarioId), HttpStatus.OK);
    }


}
