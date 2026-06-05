package com.prueba.sumativa.ddd.loan.domain.model;

public record PrestamoId(Long value) {
    public PrestamoId {
        if (value <= 0) {
            throw new IllegalArgumentException("El PrestamoId debe ser mayor a 0");
        }
    }
}

