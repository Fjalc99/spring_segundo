package com.salesianostriana.ejercicio3.repository;

import com.salesianostriana.ejercicio3.model.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {

    /*filtrar por marca
    y que contenga esa cadena de caracteres*/

    List<Bicicleta>findByMarca(String Marca);

    List<Bicicleta>findByMarcaContaining(String Marca);



}
