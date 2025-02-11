package com.salesianos.pruebaseguridad2.repo;

import com.salesianos.pruebaseguridad2.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
