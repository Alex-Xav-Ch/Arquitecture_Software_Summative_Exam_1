package com.prueba.sumativa.ddd.catalog.domain.valueObject;

public record CantidadDisponible(Integer value) {

    public CantidadDisponible {
        if (value == null) {
            throw new IllegalArgumentException("La cantidad no puede ser nula");
        }
        if (value < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
    }

    public static CantidadDisponible cero() {
        return new CantidadDisponible(0);
    }

    public static CantidadDisponible uno() {
        return new CantidadDisponible(1);
    }
}