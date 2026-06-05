package com.prueba.sumativa.ddd.catalog.application.dto;

public record LibroResponse(
    Long id,
    String isbn,
    String titulo,
    String autor,
    Integer anioPublicacion,
    Integer cantidadDisponible
) {}