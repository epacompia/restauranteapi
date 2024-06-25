package com.example.restaurante.service;



import com.example.restaurante.dtos.TipoUsuarioCreateDTO;
import com.example.restaurante.dtos.TipoUsuarioDTO;
import com.example.restaurante.dtos.TipoUsuarioUpdateDTO;

import java.util.List;

public interface TipoUsuarioService {
    List<TipoUsuarioDTO> listarTipoUsuarios();
    TipoUsuarioDTO obtenerTipoUsuarioPorId(Integer id);
    TipoUsuarioDTO
    registrarTipoUsuario(TipoUsuarioCreateDTO tipoUsuarioCreateDTO);
    TipoUsuarioDTO actualizarTipoUsuario(TipoUsuarioUpdateDTO tipoUsuarioUpdateDTO);
    String eliminarTipoUsuario(Integer id);
}
