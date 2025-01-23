package com.salesianos.joined.repository;

import com.salesianos.joined.models.Enfermero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfermeroRepository extends JpaRepository<Enfermero, Long> {
}
