package com.genesis1.mutual.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Data
@ToString
@Builder
public class EmpleadoDto implements Serializable {

    private Integer idEmpleado;
    private String nombres;
    private String apellidos;
    private String correo;
    private Integer edad;
    private String sexo;

}