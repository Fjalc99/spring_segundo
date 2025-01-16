package com.salesianostriana.apartado1.repository;

import com.salesianostriana.apartado1.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
