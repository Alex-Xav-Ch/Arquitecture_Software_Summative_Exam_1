package com.prueba.sumativa.ddd.catalog.domain.model;

import com.prueba.sumativa.ddd.catalog.domain.exception.CantidadDisponibleInvalidaException;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.AnioPublicacion;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.CantidadDisponible;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.ISBN;

public class Libro {

    private LibroId id;
    private ISBN isbn;
    private String titulo;
    private String autor;
    private AnioPublicacion anioPublicacion;
    private CantidadDisponible cantidadDisponible;

    protected Libro(LibroId id,
                  ISBN isbn,
                  String titulo,
                  String autor,
                  AnioPublicacion anioPublicacion,
                  CantidadDisponible cantidadDisponible) {

        this.id = id;
        this.isbn = isbn;
        this.titulo = requireTexto(titulo, "título");
        this.autor = requireTexto(autor, "autor");
        this.anioPublicacion = anioPublicacion;
        this.cantidadDisponible = cantidadDisponible;
    }

    public void actualizar(
        String titulo,
        String autor,
        AnioPublicacion anioPublicacion,
        CantidadDisponible cantidadDisponible
    ) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.cantidadDisponible = cantidadDisponible;
    }

    private static String requireTexto(String value, String campo) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El " + campo + " es obligatorio");
        }
        return value;
    }

    public void disminuirDisponibilidad() {

        if (cantidadDisponible.value() <= 0) {
            throw new CantidadDisponibleInvalidaException();
        }

        this.cantidadDisponible = new CantidadDisponible(cantidadDisponible.value() - 1);
    }

    public void incrementarDisponibilidad() {
        this.cantidadDisponible = new CantidadDisponible(cantidadDisponible.value() + 1);
    }

    public LibroId getId() {
        return id;
    }

    public ISBN getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public AnioPublicacion getAnioPublicacion() {
        return anioPublicacion;
    }

    public CantidadDisponible getCantidadDisponible() {
        return cantidadDisponible;
    }
}