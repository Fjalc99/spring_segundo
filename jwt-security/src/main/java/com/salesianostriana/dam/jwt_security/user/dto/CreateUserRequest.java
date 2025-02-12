package com.salesianostriana.dam.jwt_security.user.dto;

public record CreateUserRequest(String username, String password, String verifyPassword) {
}
