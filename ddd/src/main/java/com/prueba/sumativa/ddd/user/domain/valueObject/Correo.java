package com.prueba.sumativa.ddd.user.domain.valueObject;

public record Correo(String value) {

    public Correo {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Correo obligatorio");
        }

        if (!value.contains("@")) {
            throw new IllegalArgumentException("Correo inválido");
        }
    }
}
