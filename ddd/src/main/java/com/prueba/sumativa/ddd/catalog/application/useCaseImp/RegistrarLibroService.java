package com.prueba.sumativa.ddd.catalog.application.useCaseImp;

import com.prueba.sumativa.ddd.catalog.application.command.RegistrarLibroCommand;
import com.prueba.sumativa.ddd.catalog.application.dto.LibroResponse;
import com.prueba.sumativa.ddd.catalog.application.port.in.RegistrarLibroUseCase;
import com.prueba.sumativa.ddd.catalog.domain.exception.ISBNDuplicadoException;
import com.prueba.sumativa.ddd.catalog.domain.model.Libro;
import com.prueba.sumativa.ddd.catalog.domain.model.LibroFactory;
import com.prueba.sumativa.ddd.catalog.domain.repository.LibroRepository;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.AnioPublicacion;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.ISBN;

public class RegistrarLibroService implements RegistrarLibroUseCase {

    private final LibroRepository libroRepository;

    public RegistrarLibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public LibroResponse execute(RegistrarLibroCommand command) {

        ISBN isbn = new ISBN(command.isbn());

        if (libroRepository.existsByISBN(isbn)) {
            throw new ISBNDuplicadoException(isbn.value());
        }

        Libro libro = LibroFactory.crearNuevo(
                isbn,
                command.titulo(),
                command.autor(),
                new AnioPublicacion(command.anioPublicacion())
        );

        Libro saved = libroRepository.save(libro);

        return map(saved);
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