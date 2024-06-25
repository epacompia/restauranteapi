package com.example.restaurante.dtos;

import com.example.restaurante.model.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class PedidoDTO {

    private Integer id;
    private String fecha;
    private String hora;
    private Double total;
    private Integer estado;
    private UsuarioDTO usuario;


}
