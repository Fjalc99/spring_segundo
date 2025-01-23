package com.salesianos.singleTable.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@Entity
@ToString(callSuper = true)
@SuperBuilder
@DiscriminatorValue("Cancion")
@AllArgsConstructor
@NoArgsConstructor
public class Cancion extends Contenido{

    private double duracion;

    private String album;


}
