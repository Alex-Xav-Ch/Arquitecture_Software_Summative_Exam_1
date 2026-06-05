package com.prueba.sumativa.ddd.catalog.domain.valueObject;

import java.time.Year;

public record AnioPublicacion(Integer value) {
    public AnioPublicacion {
        if (value == null) {
            throw new IllegalArgumentException("El año no puede ser nulo");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("El año debe ser mayor a 0");
        }
        if (value > Year.now().getValue()) {
            throw new IllegalArgumentException("El año no puede ser futuro");
        }
    }
}