package com.example.restaurante.dtos;

import lombok.Data;

@Data
public class UsuarioUpdateDTO {

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
