package com.example.restaurante.mappers;

import com.example.restaurante.dtos.UsuarioCreateDTO;
import com.example.restaurante.dtos.UsuarioDTO;
import com.example.restaurante.dtos.UsuarioUpdateDTO;
import com.example.restaurante.model.Usuario;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {
    
    UsuarioMapper instancia= Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "tipousuario", source = "tipousuario")
    UsuarioDTO usuarioAUsuarioDTO(Usuario usuario);

    @Mapping(target = "tipousuario", source = "tipousuario")
    Usuario usuarioDTOAUsuario(UsuarioDTO usuarioDTO);

    @Mapping(target = "tipousuario", source = "tipousuario")
    Usuario usuarioCreateDTOAUsuario(UsuarioCreateDTO usuarioCreateDTO);

    @Mapping(target = "tipousuario", source = "tipousuario")
    Usuario usuarioUpdateDTOAUsuario(UsuarioUpdateDTO usuarioUpdateDTO);

    @Mapping(target = "tipousuario", source = "tipousuario")
    List<UsuarioDTO> listaUsuarioAListaUsuarioDTO (List<Usuario> listaUsuario);
}
