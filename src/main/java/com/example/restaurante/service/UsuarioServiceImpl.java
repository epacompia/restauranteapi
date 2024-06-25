package com.example.restaurante.service;

import com.example.restaurante.dtos.UsuarioCreateDTO;
import com.example.restaurante.dtos.UsuarioDTO;
import com.example.restaurante.dtos.UsuarioUpdateDTO;
import com.example.restaurante.mappers.UsuarioMapper;
import com.example.restaurante.model.Usuario;
import com.example.restaurante.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{


    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return UsuarioMapper.instancia.listaUsuarioAListaUsuarioDTO(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId(Integer id) {
        Optional<Usuario> usuario=usuarioRepository.findById(id);
        return usuario.map(UsuarioMapper.instancia::usuarioAUsuarioDTO).orElse(null);
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO) {
        Usuario usuario=UsuarioMapper.instancia.usuarioCreateDTOAUsuario(usuarioCreateDTO);
        Usuario respuestaEntity=usuarioRepository.save(usuario);
        return UsuarioMapper.instancia.usuarioAUsuarioDTO(respuestaEntity);
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuario=UsuarioMapper.instancia.usuarioUpdateDTOAUsuario(usuarioUpdateDTO);
        Usuario respuestaEntity=usuarioRepository.save(usuario);
        return UsuarioMapper.instancia.usuarioAUsuarioDTO(respuestaEntity);
    }

    @Override
    public String eliminarUsuario(Integer id) {
        Optional<Usuario> usuarioOptional=usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            usuarioRepository.delete(usuarioOptional.get());
            return "Registro Eliminado";
        }else {
            return "No se pudo eliminar";
        }
    }
}
