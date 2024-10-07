package com.salesianostriana.dam.ejercicioevaluaciondto.model;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Enabled
@AllArgsConstructor
public class MatriculasNotasPK implements Serializable {

    private Long codAlumno;

    private Long idAsignatura;

}
