package com.salesianostriana.dam.dto.apartado2.dto;

import com.salesianostriana.dam.dto.apartado2.models.Alumno;
import com.salesianostriana.dam.dto.apartado2.models.Curso;
import com.salesianostriana.dam.dto.apartado2.models.Direccion;

public record AlumnoDto (String nombre, String apellidos, String email, Curso curso, Direccion direccion) {

    public static AlumnoDto of (Alumno alumno){
        return new AlumnoDto(alumno.getNombre(), alumno.getApellido1()+' '+alumno.getApellido2(),
                alumno.getEmail(), alumno.getCurso(), alumno.getDireccion());
    }
}
