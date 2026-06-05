package com.prueba.sumativa.ddd.loan.application.dto;

import java.time.LocalDate;

import com.prueba.sumativa.ddd.loan.domain.valueObject.EstadoPrestamo;

public record PrestamoResponse(
        Long id,
        Long libroId,
        Long usuarioId,
        LocalDate fechaPrestamo,
        LocalDate fechaDevolucion,
        EstadoPrestamo estado
) {}