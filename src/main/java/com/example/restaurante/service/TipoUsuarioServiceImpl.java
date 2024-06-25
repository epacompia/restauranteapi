package com.example.restaurante.service;

import com.example.restaurante.dtos.TipoUsuarioCreateDTO;
import com.example.restaurante.dtos.TipoUsuarioDTO;
import com.example.restaurante.dtos.TipoUsuarioUpdateDTO;
import com.example.restaurante.mappers.TipoUsuarioMapper;
import com.example.restaurante.model.TipoUsuario;
import com.example.restaurante.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService{


    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioServiceImpl(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @Override
    public List<TipoUsuarioDTO> listarTipoUsuarios() {
        return TipoUsuarioMapper.instancia.listaTipoUsuarioATipoUsuarioDTO(tipoUsuarioRepository.findAll());
    }

    @Override
    public TipoUsuarioDTO obtenerTipoUsuarioPorId(Integer id) {
        Optional<TipoUsuario> tipoUsuario=tipoUsuarioRepository.findById(id);
        return tipoUsuario.map(TipoUsuarioMapper.instancia::tipoUsuarioATipoUsuarioDTO).orElse(null);
    }

    @Override
    public TipoUsuarioDTO registrarTipoUsuario(TipoUsuarioCreateDTO tipoUsuarioCreateDTO) {
        TipoUsuario tipoUsuario=TipoUsuarioMapper.instancia.tipoUsuarioCreateDTOATipoUsuario(tipoUsuarioCreateDTO);
        TipoUsuario respuestaEntity=tipoUsuarioRepository.save(tipoUsuario);
        return TipoUsuarioMapper.instancia.tipoUsuarioATipoUsuarioDTO(respuestaEntity);
    }

    @Override
    public TipoUsuarioDTO actualizarTipoUsuario(TipoUsuarioUpdateDTO tipoUsuarioUpdateDTO) {
        TipoUsuario tipoUsuario=TipoUsuarioMapper.instancia.tipoUsuarioUpdateDTOATipoUsuario(tipoUsuarioUpdateDTO);
        TipoUsuario respuestaEntity=tipoUsuarioRepository.save(tipoUsuario);
        return TipoUsuarioMapper.instancia.tipoUsuarioATipoUsuarioDTO(respuestaEntity);
    }

    @Override
    public String eliminarTipoUsuario(Integer id) {
        Optional<TipoUsuario> tipoUsuarioOptional=tipoUsuarioRepository.findById(id);
        if (tipoUsuarioOptional.isPresent()){
            tipoUsuarioRepository.delete(tipoUsuarioOptional.get());
            return "Registro Eliminado";
        }else {
            return "No se pudo eliminar";
        }
    }
}
