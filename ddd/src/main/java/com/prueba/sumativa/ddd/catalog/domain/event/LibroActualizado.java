package com.prueba.sumativa.ddd.catalog.domain.event;

import java.time.LocalDateTime;

public class LibroActualizado {

    private final Long libroId;
    private final LocalDateTime fechaOcurrencia;

    public LibroActualizado(Long libroId) {
        this.libroId = libroId;
        this.fechaOcurrencia = LocalDateTime.now();
    }

    public Long getLibroId() {
        return libroId;
    }

    public LocalDateTime getFechaOcurrencia() {
        return fechaOcurrencia;
    }
}