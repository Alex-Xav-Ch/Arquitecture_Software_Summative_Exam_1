package com.prueba.sumativa.ddd.user.domain.model;

public record UsuarioId(Long value) {
    public UsuarioId {
        if (value <= 0) {
            throw new IllegalArgumentException("El UsuarioId debe ser mayor a 0");
        }
    }
}