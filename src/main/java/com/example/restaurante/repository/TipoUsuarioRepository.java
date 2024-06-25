package com.example.restaurante.repository;

import com.example.restaurante.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Integer> {
}
