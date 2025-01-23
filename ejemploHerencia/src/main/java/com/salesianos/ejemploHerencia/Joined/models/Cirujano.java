package com.salesianos.ejemploHerencia.Joined.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
@SuperBuilder
@Entity
@MappedSuperclass
@DiscriminatorValue("Cirujano")
public class Cirujano extends Trabajador {

    private String numConsulta;



}
