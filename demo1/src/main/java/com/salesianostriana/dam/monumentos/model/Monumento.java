package com.salesianostriana.dam.monumentos.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumento {

    @Id
    @GeneratedValue
    private Long id;

    private String codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private String latitud;
    private String longitud;
    private String nombreMonumento;
    private String descripcion;
    private String imagen;
}
