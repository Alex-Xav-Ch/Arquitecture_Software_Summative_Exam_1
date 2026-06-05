package com.prueba.sumativa.ddd.loan.infrastructure.adapter.out.persistence;

import com.prueba.sumativa.ddd.loan.domain.model.*;
import com.prueba.sumativa.ddd.loan.domain.valueObject.FechaDevolucion;
import com.prueba.sumativa.ddd.loan.domain.valueObject.FechaPrestamo;
import com.prueba.sumativa.ddd.loan.domain.valueObject.LibroId;
import com.prueba.sumativa.ddd.loan.domain.valueObject.UsuarioId;

public final class PrestamoPersistenceMapper {

    private PrestamoPersistenceMapper() {
    }

    public static PrestamoEntity toEntity(Prestamo prestamo) {
        return new PrestamoEntity(
                prestamo.getId() != null 
                        ? prestamo.getId().value() 
                        : null,
                prestamo.getLibroId().value(),
                prestamo.getUsuarioId().value(),
                prestamo.getFechaPrestamo().value(),
                prestamo.getFechaDevolucion() != null
                        ? prestamo.getFechaDevolucion().value()
                        : null,
                prestamo.getEstado()
        );
    }

    public static Prestamo toDomain(PrestamoEntity entity) {
        return PrestamoFactory.actualizar(
                entity.getId() != null
                        ? new PrestamoId(entity.getId())
                        : null,
                new LibroId(entity.getLibroId()),
                new UsuarioId(entity.getUsuarioId()),
                new FechaPrestamo(entity.getFechaPrestamo()),
                entity.getFechaDevolucion() != null
                        ? new FechaDevolucion(entity.getFechaDevolucion())
                        : null,
                entity.getEstado()
        );
    }
}
