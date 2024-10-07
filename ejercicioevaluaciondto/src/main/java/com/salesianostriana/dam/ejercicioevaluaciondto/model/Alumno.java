package com.salesianostriana.dam.ejercicioevaluaciondto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.profile.Fetch;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno implements Serializable {

    @Id
    @GeneratedValue
    private Long codAlumno;

    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "alumno_id",
            foreignKey = @ForeignKey(name="FK_MATRICULA_ALUMNO")),
            inverseJoinColumns = @JoinColumn(name = "asignatura_id",
                    foreignKey = @ForeignKey(name="FK_MATRICULA_ASIGNATURA"))

    )
    private List<Asignatura> asignaturas = new ArrayList<>();

    private LocalDate fechaNac;


    public void addAsignatura(Asignatura a){
        this.getAsignaturas().add(a);
        a.getAlumnos().add(this);
    }

    public void removeAsignatura(Asignatura a){
        a.getAlumnos().remove(this);
        this.getAsignaturas().remove(a);
    }




}
