package com.salesianostriana.apartado1.repository;

import com.salesianostriana.apartado1.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
