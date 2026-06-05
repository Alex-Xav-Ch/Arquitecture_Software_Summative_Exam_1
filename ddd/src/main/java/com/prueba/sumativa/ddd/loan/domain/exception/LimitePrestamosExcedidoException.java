package com.prueba.sumativa.ddd.loan.domain.exception;

public class LimitePrestamosExcedidoException extends RuntimeException {

    public LimitePrestamosExcedidoException() {
        super("El usuario alcanzó el límite máximo de 3 préstamos activos.");
    }
}