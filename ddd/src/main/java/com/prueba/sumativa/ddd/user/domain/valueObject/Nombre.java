package com.prueba.sumativa.ddd.user.domain.valueObject;

public record Nombre(String value) {

    public Nombre {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Nombre obligatorio");
        }
    }
}
