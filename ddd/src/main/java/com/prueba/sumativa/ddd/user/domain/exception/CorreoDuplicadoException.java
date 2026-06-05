package com.prueba.sumativa.ddd.user.domain.exception;

public class CorreoDuplicadoException extends RuntimeException {

    public CorreoDuplicadoException(String correo) {
        super("El correo ya existe: " + correo);
    }
}