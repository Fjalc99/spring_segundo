package com.salesianostriana.dam.ejercicioevaluaciondto.repository;

import com.salesianostriana.dam.ejercicioevaluaciondto.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
