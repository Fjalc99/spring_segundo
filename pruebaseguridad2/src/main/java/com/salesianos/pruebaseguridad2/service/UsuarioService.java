package com.salesianos.pruebaseguridad2.service;


import com.salesianos.pruebaseguridad2.dto.CreateUserRequestDto;
import com.salesianos.pruebaseguridad2.error.UsuarioNotFoundException;
import com.salesianos.pruebaseguridad2.models.UserRole;
import com.salesianos.pruebaseguridad2.models.Usuario;
import com.salesianos.pruebaseguridad2.repo.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public Usuario crearUsuario(CreateUserRequestDto createUserRequestDto, EnumSet<UserRole> roles){
        Usuario usuario = Usuario.builder()
                .username(createUserRequestDto.username())
                .password(passwordEncoder.encode(createUserRequestDto.password()))
                .avatar(createUserRequestDto.avatar())
                .fullName(createUserRequestDto.fullName())
                .roles(roles)
                .build();

        return usuarioRepository.save(usuario);
    }


    public Usuario crearRolUsuario(CreateUserRequestDto dto) {
        return crearUsuario(dto, EnumSet.of(UserRole.USER));
    }


    public Usuario crearRolAdmin(CreateUserRequestDto dto) {
        return crearUsuario(dto, EnumSet.of(UserRole.ADMIN));
    }


    public Usuario editarUsuario(Usuario usuario){
        return usuarioRepository.findById(usuario.getId()).map(
                u-> {
                    u.setAvatar(usuario.getAvatar());
                    u.setFullName(usuario.getFullName());
                    return usuarioRepository.save(u);

                }).orElseThrow(() -> new UsuarioNotFoundException());
    }

}
