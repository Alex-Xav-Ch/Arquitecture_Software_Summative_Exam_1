package com.prueba.sumativa.ddd.loan.domain.valueObject;

public record LibroId(Long value) {
    public LibroId {
        if (value <= 0) {
            throw new IllegalArgumentException("El LibroId debe ser mayor a 0");
        }
    }
}