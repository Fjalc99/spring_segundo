package com.salesianos.ejemploHerencia.Joined.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@SuperBuilder
@DiscriminatorValue("Enfermero")
public class Enfermero extends Trabajador{

    private String carritoAsignado;



}
