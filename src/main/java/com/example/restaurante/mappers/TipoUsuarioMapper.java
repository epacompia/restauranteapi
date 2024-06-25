package com.example.restaurante.mappers;

import com.example.restaurante.dtos.TipoUsuarioCreateDTO;
import com.example.restaurante.dtos.TipoUsuarioDTO;
import com.example.restaurante.dtos.TipoUsuarioUpdateDTO;
import com.example.restaurante.model.TipoUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoUsuarioMapper {
    TipoUsuarioMapper instancia= Mappers.getMapper(TipoUsuarioMapper.class);
    TipoUsuarioDTO tipoUsuarioATipoUsuarioDTO(TipoUsuario tipoUsuario);
    TipoUsuario tipoUsuarioDTOATipoUsuario(TipoUsuarioDTO tipoUsuarioDTO);
    TipoUsuario tipoUsuarioCreateDTOATipoUsuario(TipoUsuarioCreateDTO tipoUsuarioCreateDTO);
    TipoUsuario tipoUsuarioUpdateDTOATipoUsuario(TipoUsuarioUpdateDTO tipoUsuarioUpdateDTO);

    List<TipoUsuarioDTO> listaTipoUsuarioATipoUsuarioDTO (List<TipoUsuario> listaTipoUsuario);

}
