package com.salesianostriana.dam.ejercicioevaluaciondto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asignatura implements Serializable {

    @Id
    @GeneratedValue
    private Long  idAsignatura;

    private String nombreAsignatura;
    private int numHoras;
    private String contenidos;

    @Builder.Default
    @ManyToMany(mappedBy = "asignaturas", fetch = FetchType.EAGER)
    private List <Alumno> alumnos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "asignatura", foreignKey = @ForeignKey(name = "FK_ASIGNATURA_CURSO"))
    private Curso curso;


}
