package com.salesianos.pruebaseguridad2.controller;


import com.salesianos.pruebaseguridad2.dto.CreateUserRequestDto;
import com.salesianos.pruebaseguridad2.models.Usuario;
import com.salesianos.pruebaseguridad2.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/usuario")
@RestController
public class UsuarioController {


    private final UsuarioService usuarioService;


    @PostMapping("/nuevoUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody CreateUserRequestDto u){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearRolUsuario(u));
    }

    @PostMapping("/nuevoAdmin")
    public ResponseEntity<Usuario> crearAdmin(@RequestBody CreateUserRequestDto u){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearRolAdmin(u));
    }

    @PutMapping("/editarUsuario")
    public Usuario editarUsuario(@RequestBody Usuario u){
        return usuarioService.editarUsuario(u);
    }

}
