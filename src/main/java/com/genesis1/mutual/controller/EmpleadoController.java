package com.genesis1.mutual.controller;


import com.genesis1.mutual.model.dto.EmpleadoDto;
import com.genesis1.mutual.model.entity.Empleado;
import com.genesis1.mutual.model.payload.MensajeResponse;
import com.genesis1.mutual.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("empleados")
    public ResponseEntity<?> showAll() {
        List<Empleado> getList = empleadoService.listAlll();
        if (getList == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message("No hay registros")
                            .code("404")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .message("")
                        .code("200")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }


    @PostMapping("empleado")
    public ResponseEntity<?> create(@RequestBody EmpleadoDto empleadoDto) {
        Empleado empleadoSave = null;
        try {
            empleadoSave = empleadoService.save(empleadoDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .message("Guardado correctamente")
                    .object(EmpleadoDto.builder()
                            .idEmpleado(empleadoSave.getIdEmpleado())
                            .nombres(empleadoSave.getNombres() )
                            .apellidos(empleadoSave.getApellidos())
                            .correo(empleadoSave.getCorreo())
                            .edad(empleadoSave.getEdad())
                            .sexo(empleadoSave.getSexo())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message(exDt.getMessage())
                            .object(null)
                            .code("500")
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("empleado/{id}")
    public ResponseEntity<?> update(@RequestBody EmpleadoDto empleadoDto, @PathVariable Integer id) {
        Empleado empleadoUpdate = null;
        try {
            if (empleadoService.existsById(id)) {
                empleadoDto.setIdEmpleado(id);
                empleadoUpdate = empleadoService.save(empleadoDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .message("Actualizado correctamente")
                        .object(Empleado.builder()
                                .idEmpleado(empleadoUpdate.getIdEmpleado())
                                .nombres(empleadoUpdate.getNombres())
                                .apellidos(empleadoUpdate.getApellidos())
                                .correo(empleadoUpdate.getCorreo())
                                .edad(empleadoUpdate.getEdad())
                                .sexo(empleadoUpdate.getSexo())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .message("El registro que intenta actualizar no se encuentra en la base de datos.")
                                .object(null)
                                .code("404")
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message(exDt.getMessage())
                            .object(null)
                            .code("500")
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Empleado empleadoDelete = empleadoService.findById(id);
            empleadoService.delete(empleadoDelete);
            return new ResponseEntity<>(empleadoDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message(exDt.getMessage())
                            .object(null)
                            .code("500")
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("empleado/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Empleado empleado = empleadoService.findById(id);

        if (empleado == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message("El registro que intenta buscar, no existe!!")
                            .object(null)
                            .code("404")
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .message("")
                        .object(Empleado.builder()
                                .idEmpleado(empleado.getIdEmpleado())
                                .nombres(empleado.getNombres())
                                .apellidos(empleado.getApellidos())
                                .correo(empleado.getCorreo())
                                .edad(empleado.getEdad())
                                .sexo(empleado.getSexo())
                                .build())
                        .code("200")
                        .build()
                , HttpStatus.OK);
    }
    @GetMapping("empleados/sexo/{sexo}")
    public ResponseEntity<?> ListBySex(@PathVariable String sexo) {
        List<Empleado> getList = empleadoService.listBySexo(sexo);


        if (getList == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message("No hay registros")
                            .object(null)
                            .code("404")
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .message("")
                        .object(getList)
                        .code("200")
                        .build()
                , HttpStatus.OK);
    }
    @GetMapping("empleados/edad/{edad}")
    public ResponseEntity<?> getEmpleadoFilterByEdad(@PathVariable Integer edad) {
        List<Empleado> getList = (List<Empleado>) empleadoService.getEmpleadoFilterByEdad(edad);


        if (getList == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .message("No hay registros")
                            .object(null)
                            .code("404")
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .message("")
                        .object(getList)
                        .code("200")
                        .build()
                , HttpStatus.OK);
    }


}
