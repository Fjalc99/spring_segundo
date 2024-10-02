package com.salesianostriana.dam.ejercicio_evaluacion1.repository;

import com.salesianostriana.dam.ejercicio_evaluacion1.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Optional<Place> findById(Long id);
}
