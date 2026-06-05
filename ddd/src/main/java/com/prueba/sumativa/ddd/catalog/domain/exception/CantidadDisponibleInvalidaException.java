package com.prueba.sumativa.ddd.catalog.domain.exception;

public class CantidadDisponibleInvalidaException extends RuntimeException {

    public CantidadDisponibleInvalidaException() {
        super("No existen ejemplares disponibles");
    }
}