package com.prueba.sumativa.ddd.catalog.domain.event;

import java.time.LocalDateTime;

public class LibroRegistrado {

    private final Long libroId;
    private final String isbn;
    private final LocalDateTime fechaOcurrencia;

    public LibroRegistrado(Long libroId, String isbn) {
        this.libroId = libroId;
        this.isbn = isbn;
        this.fechaOcurrencia = LocalDateTime.now();
    }

    public Long getLibroId() {
        return libroId;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getFechaOcurrencia() {
        return fechaOcurrencia;
    }
}