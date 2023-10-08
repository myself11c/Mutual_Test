package com.genesis1.mutual.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "EMPLEADOS")
public class Empleado implements Serializable {

    @Id
    @Column(name = "id_Empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "correo")
    private String correo;
    @Column(name = "edad")
    private Integer edad;

}
