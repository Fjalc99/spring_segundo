package com.salesianos.mappedsuperclass.repository;

import com.salesianos.mappedsuperclass.models.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<Moto, Long> {
}
