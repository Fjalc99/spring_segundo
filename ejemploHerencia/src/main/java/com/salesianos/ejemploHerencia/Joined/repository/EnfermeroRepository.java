package com.salesianos.ejemploHerencia.Joined.repository;

import com.salesianos.ejemploHerencia.Joined.models.Enfermero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfermeroRepository extends JpaRepository<Enfermero, Long> {
}
