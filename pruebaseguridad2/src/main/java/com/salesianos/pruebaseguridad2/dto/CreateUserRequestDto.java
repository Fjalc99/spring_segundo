package com.salesianos.pruebaseguridad2.dto;

public record CreateUserRequestDto(String username,
                                   String password,
                                   String verifyPassword,
                                   String avatar,
                                   String fullName) {



}
