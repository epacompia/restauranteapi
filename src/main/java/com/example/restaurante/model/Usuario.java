package com.example.restaurante.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    private String email;
    private String celular;
    private String dni;
    private String fec_nac;
    private String direccion;
    private Integer estado;
    @ManyToOne()
    @JoinColumn(name = "tipousuarioid")
    private TipoUsuario tipousuario;

}
