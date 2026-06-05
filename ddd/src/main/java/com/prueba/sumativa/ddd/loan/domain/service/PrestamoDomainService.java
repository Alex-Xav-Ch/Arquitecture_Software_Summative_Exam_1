package com.prueba.sumativa.ddd.loan.domain.service;

import com.prueba.sumativa.ddd.loan.domain.exception.LimitePrestamosExcedidoException;

public class PrestamoDomainService {
    public void validarLimitePrestamos(long prestamosActivos) {
        if (prestamosActivos >= 3) {
            throw new LimitePrestamosExcedidoException();
        }
    }
}