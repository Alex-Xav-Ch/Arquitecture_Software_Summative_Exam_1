package com.prueba.sumativa.ddd.loan.domain.exception;

public class LibroNoDisponibleException extends RuntimeException {

    public LibroNoDisponibleException() {
        super("El libro no tiene ejemplares disponibles.");
    }
}
