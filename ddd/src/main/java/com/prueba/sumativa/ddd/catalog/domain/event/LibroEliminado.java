package com.prueba.sumativa.ddd.catalog.domain.event;

import java.time.LocalDateTime;

public class LibroEliminado {

    private final Long libroId;
    private final LocalDateTime fechaOcurrencia;

    public LibroEliminado(Long libroId) {
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
