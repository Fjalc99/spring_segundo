package com.salesianostriana.dam.ejercicioevaluaciondto.repository;

import com.salesianostriana.dam.ejercicioevaluaciondto.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
