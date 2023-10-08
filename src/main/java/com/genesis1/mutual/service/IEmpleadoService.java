package com.genesis1.mutual.service;

import com.genesis1.mutual.model.entity.Empleado;
import com.genesis1.mutual.model.dto.EmpleadoDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface IEmpleadoService {

    List<Empleado> listAlll();

    Empleado save(EmpleadoDto empleado);

    Empleado findById(Integer id);

    void delete(Empleado empleado);

    boolean existsById(Integer id);

    List<Empleado> listBySexo(String sexo);

    @Query("SELECT * FROM EMPLEADDOS  WHERE edad  <= 40")
    Empleado getEmpleadoFilterByEdad(@Param("edad") Integer edad);



}