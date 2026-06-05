package com.prueba.sumativa.ddd.catalog.application.command;

public record RegistrarLibroCommand(
    String isbn,
    String titulo,
    String autor,
    Integer anioPublicacion,
    Integer cantidadDisponible
) {}
