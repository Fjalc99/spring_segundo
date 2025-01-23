package com.salesianos.singleTable.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("Pelicula")
public class Pelicula extends Contenido {

    private double duracion;

    private String genero;


}
