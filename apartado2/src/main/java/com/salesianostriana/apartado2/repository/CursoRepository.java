package com.salesianostriana.apartado2.repository;

import com.salesianostriana.apartado2.models.CursoOnline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoOnline, Long> {
}
