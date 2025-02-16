package com.salesianostriana.dam.jwt.security.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.salesianostriana.dam.jwt.security.user.model.User;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String token,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String refreshToken,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String email // Se agrega el campo email
) {

    public static UserResponse of (User user) {
        return new UserResponse(user.getId(), user.getUsername(), null, null, user.getEmail()); // Se pasa el email
    }

    public static UserResponse of (User user, String token, String refreshToken) {
        return new UserResponse(user.getId(), user.getUsername(), token, refreshToken, user.getEmail()); // Se pasa el email
    }
}
