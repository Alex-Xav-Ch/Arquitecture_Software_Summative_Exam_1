package com.prueba.sumativa.ddd.catalog.application.useCaseImp;

import com.prueba.sumativa.ddd.catalog.application.command.ActualizarLibroCommand;
import com.prueba.sumativa.ddd.catalog.application.dto.LibroResponse;
import com.prueba.sumativa.ddd.catalog.application.port.in.ActualizarLibroUseCase;
import com.prueba.sumativa.ddd.catalog.domain.exception.LibroNoEncontradoException;
import com.prueba.sumativa.ddd.catalog.domain.model.Libro;
import com.prueba.sumativa.ddd.catalog.domain.model.LibroId;
import com.prueba.sumativa.ddd.catalog.domain.repository.LibroRepository;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.AnioPublicacion;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.CantidadDisponible;

public class ActualizarLibroService implements ActualizarLibroUseCase {

    private final LibroRepository libroRepository;

    public ActualizarLibroService(
            LibroRepository libroRepository) {

        this.libroRepository = libroRepository;
    }

    @Override
    public LibroResponse execute(ActualizarLibroCommand command) {

        Libro libro = libroRepository.findById(new LibroId(command.id()))
                .orElseThrow(() -> new LibroNoEncontradoException(command.id()));

        libro.actualizar(
                command.titulo(),
                command.autor(),
                new AnioPublicacion(command.anioPublicacion()),
                new CantidadDisponible(command.cantidadDisponible())
        );

        Libro updated = libroRepository.save(libro);

        return map(updated);
    }

    private LibroResponse map(Libro libro) {

        return new LibroResponse(
                libro.getId().value(),
                libro.getIsbn().value(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnioPublicacion().value(),
                libro.getCantidadDisponible().value()
        );
    }
}