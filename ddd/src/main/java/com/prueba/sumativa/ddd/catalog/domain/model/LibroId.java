package com.prueba.sumativa.ddd.catalog.domain.model;

public record LibroId(Long value) {
    public LibroId {
        if (value <= 0) {
            throw new IllegalArgumentException("El LibroId debe ser mayor a 0");
        }
    }
}
