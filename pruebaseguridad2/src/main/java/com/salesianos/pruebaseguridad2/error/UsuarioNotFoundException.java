package com.salesianos.pruebaseguridad2.error;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(Long id) {
        super("Usuario " + id + " no encontrado");
    }
    public UsuarioNotFoundException(String msg) {
        super(msg);
    }
    public UsuarioNotFoundException() {
        super("No hay usuario con ese id de búsqueda");
    }
}
