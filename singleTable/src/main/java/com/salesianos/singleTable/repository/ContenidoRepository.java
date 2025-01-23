package com.salesianos.singleTable.repository;


import com.salesianos.singleTable.models.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
}
