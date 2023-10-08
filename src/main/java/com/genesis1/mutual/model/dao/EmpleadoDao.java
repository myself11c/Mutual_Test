package com.genesis1.mutual.model.dao;


import com.genesis1.mutual.model.entity.Empleado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EmpleadoDao extends CrudRepository<Empleado, Integer> {

    List<Empleado> findBySexo(String sexo);


    Object getEmpleadoFilterByEdad(Integer edad);
}
