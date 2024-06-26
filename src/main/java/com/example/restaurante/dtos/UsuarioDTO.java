package com.example.restaurante.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UsuarioDTO {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String email;
    private String celular;
    private String dni;
    private String fec_nac;
    private String direccion;
    private Integer estado;
    private TipoUsuarioDTO tipousuario;

}
