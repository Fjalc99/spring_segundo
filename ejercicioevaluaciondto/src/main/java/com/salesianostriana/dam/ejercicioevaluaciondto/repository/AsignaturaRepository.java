package com.salesianostriana.dam.ejercicioevaluaciondto.repository;

import com.salesianostriana.dam.ejercicioevaluaciondto.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
