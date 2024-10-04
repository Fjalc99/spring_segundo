package com.salesianostriana.dam.ejercicio_evaluacion1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String nombreEtiqueta;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    private List <Place> places;


}
