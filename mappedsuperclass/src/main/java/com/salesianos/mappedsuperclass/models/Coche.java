package com.salesianos.mappedsuperclass.models;


import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Coche  extends  Vehiculo{

    private int numeroDePuertas;

}
