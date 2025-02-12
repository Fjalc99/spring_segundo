package com.salesianostriana.dam.jwt_security.user.repo;

import com.salesianostriana.dam.jwt_security.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

 Optional<User> findFirtsByUsername(String username);
}
