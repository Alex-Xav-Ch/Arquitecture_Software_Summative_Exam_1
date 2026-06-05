package com.prueba.sumativa.ddd.catalog.domain.valueObject;

public record ISBN(String value) {
    public ISBN {
        if (value == null) {
            throw new IllegalArgumentException("ISBN no puede ser nulo");
        }

        if (value.isBlank()) {
            throw new IllegalArgumentException("ISBN no puede estar vacío");
        }
    }
}