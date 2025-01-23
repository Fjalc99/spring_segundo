package com.salesianos.ejemploHerencia.Joined.repository;

import com.salesianos.ejemploHerencia.Joined.models.Cirujano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CirujanoRepository extends JpaRepository<Cirujano, Long> {
}
