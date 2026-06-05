package com.prueba.sumativa.ddd.loan.domain.model;

import java.time.LocalDate;

import com.prueba.sumativa.ddd.loan.domain.valueObject.EstadoPrestamo;
import com.prueba.sumativa.ddd.loan.domain.valueObject.FechaDevolucion;
import com.prueba.sumativa.ddd.loan.domain.valueObject.FechaPrestamo;
import com.prueba.sumativa.ddd.loan.domain.valueObject.LibroId;
import com.prueba.sumativa.ddd.loan.domain.valueObject.UsuarioId;

public final class PrestamoFactory {

    private PrestamoFactory() {
    }

    public static Prestamo crearNuevo(LibroId libroId, UsuarioId usuarioId) {
        return new Prestamo(
                null,
                libroId,
                usuarioId,
                new FechaPrestamo(LocalDate.now()),
                null,
                EstadoPrestamo.ACTIVO
        );
    }

    public static Prestamo actualizar(
            PrestamoId id,
            LibroId libroId,
            UsuarioId usuarioId,
            FechaPrestamo fechaPrestamo,
            FechaDevolucion fechaDevolucion,
            EstadoPrestamo estado

    ) {
        return new Prestamo(
                id,
                libroId,
                usuarioId,
                fechaPrestamo,
                fechaDevolucion,
                estado
        );
    }
}
