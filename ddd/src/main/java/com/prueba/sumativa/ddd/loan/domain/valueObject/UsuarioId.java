package com.prueba.sumativa.ddd.loan.domain.valueObject;

public record UsuarioId(Long value) {
    public UsuarioId {
        if (value <= 0) {
            throw new IllegalArgumentException("El UsuarioId debe ser mayor a 0");
        }
    }
}