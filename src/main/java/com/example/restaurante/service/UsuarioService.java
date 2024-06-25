package com.example.restaurante.service;

import com.example.restaurante.dtos.UsuarioCreateDTO;
import com.example.restaurante.dtos.UsuarioDTO;
import com.example.restaurante.dtos.UsuarioUpdateDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> listarUsuarios();
    UsuarioDTO obtenerUsuarioPorId(Integer id);
    UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO);
    UsuarioDTO actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO);
    String eliminarUsuario(Integer id);
}
