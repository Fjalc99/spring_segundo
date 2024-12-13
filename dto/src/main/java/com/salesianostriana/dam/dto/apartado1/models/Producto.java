package com.salesianostriana.dam.dto.apartado1.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    private Long id;
    private String nombre;
    private double desc;
    private double pvp;
    private List<String> imagenes;
    private Categoria categoria;

}
