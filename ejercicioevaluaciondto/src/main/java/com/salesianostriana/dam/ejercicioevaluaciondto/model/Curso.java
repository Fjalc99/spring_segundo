package com.salesianostriana.dam.ejercicioevaluaciondto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue
    private Long idCurso;

    private String nombreCurso;

    @Enumerated
    private TipoCurso tipo;

    @OneToMany(mappedBy = "curso")
    private List<Asignatura> asignaturas = new ArrayList<>();

}
