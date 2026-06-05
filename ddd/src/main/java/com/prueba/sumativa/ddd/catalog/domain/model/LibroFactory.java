package com.prueba.sumativa.ddd.catalog.domain.model;

import com.prueba.sumativa.ddd.catalog.domain.valueObject.AnioPublicacion;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.CantidadDisponible;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.ISBN;

public class LibroFactory {

    private LibroFactory() {
        // evita instanciación
    }

    public static Libro crearNuevo(
        ISBN isbn,
        String titulo,
        String autor,
        AnioPublicacion anioPublicacion
) {
    return new Libro(
            null,
            isbn,
            titulo,
            autor,
            anioPublicacion,
            CantidadDisponible.uno()
    );
}

    public static Libro actualizar(
            LibroId id,
            ISBN isbn,
            String titulo,
            String autor,
            AnioPublicacion anioPublicacion,
            CantidadDisponible cantidadDisponible
    ) {
        return new Libro(
                id,
                isbn,
                titulo,
                autor,
                anioPublicacion,
                cantidadDisponible
        );
    }
}