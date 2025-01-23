package com.salesianos.mappedsuperclass.repository;

import com.salesianos.mappedsuperclass.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
