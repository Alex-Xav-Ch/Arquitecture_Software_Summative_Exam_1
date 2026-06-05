package com.prueba.sumativa.ddd.loan.application.dto;

import java.time.LocalDate;

import com.prueba.sumativa.ddd.loan.domain.model.Prestamo;
import com.prueba.sumativa.ddd.loan.domain.valueObject.EstadoPrestamo;

public record PrestamoResponse(
        Long id,
        Long libroId,
        Long usuarioId,
        LocalDate fechaPrestamo,
        LocalDate fechaDevolucion,
        EstadoPrestamo estado
) {
        public static PrestamoResponse from(Prestamo prestamo) {
                return new PrestamoResponse(
                        prestamo.getId().value(),
                        prestamo.getLibroId().value(),
                        prestamo.getUsuarioId().value(),
                        prestamo.getFechaPrestamo().value(),
                        prestamo.getFechaDevolucion() != null
                                ? prestamo.getFechaDevolucion().value()
                                : null,
                        prestamo.getEstado()
                );
        }
}