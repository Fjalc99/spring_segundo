package com.salesianostriana.dam.dto.apartado1.dto;

import com.salesianostriana.dam.dto.apartado1.models.Categoria;
import com.salesianostriana.dam.dto.apartado1.models.Producto;

public record ProductoDto (String nombre, double pvp, String imagenes, Categoria categoria) {

    public static ProductoDto of(Producto producto) {
        return new ProductoDto(producto.getNombre(), producto.getPvp(),
                producto.getImagenes().get(0), producto.getCategoria());
    }
}
