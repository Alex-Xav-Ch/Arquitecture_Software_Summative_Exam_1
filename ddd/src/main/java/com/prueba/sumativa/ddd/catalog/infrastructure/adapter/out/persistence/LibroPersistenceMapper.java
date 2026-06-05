package com.prueba.sumativa.ddd.catalog.infrastructure.adapter.out.persistence;

import com.prueba.sumativa.ddd.catalog.domain.model.Libro;
import com.prueba.sumativa.ddd.catalog.domain.model.LibroFactory;
import com.prueba.sumativa.ddd.catalog.domain.model.LibroId;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.AnioPublicacion;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.CantidadDisponible;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.ISBN;

public final class LibroPersistenceMapper {

    private LibroPersistenceMapper() {
    }

    public static LibroEntity toEntity(Libro libro) {
        return new LibroEntity(
                libro.getId() != null
                        ? libro.getId().value()
                        : null,
                libro.getIsbn().value(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnioPublicacion().value(),
                libro.getCantidadDisponible().value()
        );
    }

    public static Libro toDomain(LibroEntity entity) {
        return LibroFactory.actualizar(
                new LibroId(entity.getId()),
                new ISBN(entity.getIsbn()),
                entity.getTitulo(),
                entity.getAutor(),
                new AnioPublicacion(entity.getAnioPublicacion()),
                new CantidadDisponible(entity.getCantidadDisponible())
        );
    }
}