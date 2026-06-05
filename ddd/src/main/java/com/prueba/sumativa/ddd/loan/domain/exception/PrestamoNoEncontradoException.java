package com.prueba.sumativa.ddd.loan.domain.exception;

public class PrestamoNoEncontradoException extends RuntimeException {

    public PrestamoNoEncontradoException(Long id) {
        super("No existe un préstamo con id: " + id );
    }
}