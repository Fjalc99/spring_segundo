package com.salesianos.joined.repository;

import com.salesianos.joined.models.Cirujano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CirujanoRepository extends JpaRepository<Cirujano, Long> {
}
