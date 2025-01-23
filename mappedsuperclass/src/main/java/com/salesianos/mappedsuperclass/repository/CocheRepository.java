package com.salesianos.mappedsuperclass.repository;

import com.salesianos.mappedsuperclass.models.Coche;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CocheRepository extends JpaRepository<Coche, Long> {
}
