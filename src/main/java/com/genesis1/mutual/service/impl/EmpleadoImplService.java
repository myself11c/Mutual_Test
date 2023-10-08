package com.genesis1.mutual.service.impl;

import com.genesis1.mutual.model.dao.EmpleadoDao;
import com.genesis1.mutual.model.entity.Empleado;
import com.genesis1.mutual.model.dto.EmpleadoDto;

import com.genesis1.mutual.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoImplService implements IEmpleadoService {

    @Autowired
    private EmpleadoDao empleadoDao;

    @Override
    public List<Empleado> listAlll() {
        return (List) empleadoDao.findAll();
    }

    @Transactional
    @Override
    public Empleado save(EmpleadoDto empleadoDto) {
        Empleado empleado = Empleado.builder()
                .idEmpleado(empleadoDto.getIdEmpleado())
                .nombres(empleadoDto.getNombres())
                .apellidos(empleadoDto.getApellidos())
                .correo(empleadoDto.getCorreo())
                .edad(empleadoDto.getEdad())
                .sexo(empleadoDto.getSexo())
                .build();
        return empleadoDao.save(empleado);
    }

    @Transactional(readOnly = true)
    @Override
    public Empleado findById(Integer id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    @Override
    public boolean existsById(Integer id) {
        return empleadoDao.existsById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Empleado> listBySexo(String sexo) {
        return   empleadoDao.findBySexo(sexo);
    }

    @Override
    public Empleado getEmpleadoFilterByEdad(Integer edad) {
        return (Empleado) empleadoDao.getEmpleadoFilterByEdad(edad);
    }


}
