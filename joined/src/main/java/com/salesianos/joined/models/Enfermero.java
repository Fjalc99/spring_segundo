package com.salesianos.joined.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
@DiscriminatorValue("Enfermero")
@Entity
public class Enfermero extends Trabajador{

    private String areaDetrabajo;



}
