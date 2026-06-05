package com.prueba.sumativa.ddd.catalog.application.command;

public record ActualizarLibroCommand(
        Long id,
        String titulo,
        String autor,
        Integer anioPublicacion,
        Integer cantidadDisponible
) {}
