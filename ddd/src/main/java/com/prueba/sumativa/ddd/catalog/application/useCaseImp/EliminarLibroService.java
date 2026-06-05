package com.prueba.sumativa.ddd.catalog.application.useCaseImp;

import com.prueba.sumativa.ddd.catalog.application.command.EliminarLibroCommand;
import com.prueba.sumativa.ddd.catalog.application.port.in.EliminarLibroUseCase;
import com.prueba.sumativa.ddd.catalog.domain.exception.LibroNoEncontradoException;
import com.prueba.sumativa.ddd.catalog.domain.model.Libro;
import com.prueba.sumativa.ddd.catalog.domain.model.LibroId;
import com.prueba.sumativa.ddd.catalog.domain.repository.LibroRepository;

public class EliminarLibroService implements EliminarLibroUseCase {

    private final LibroRepository libroRepository;

    public EliminarLibroService(
            LibroRepository libroRepository) {

        this.libroRepository = libroRepository;
    }

    @Override
    public void execute(EliminarLibroCommand command) {
        Libro libro = libroRepository.findById(new LibroId(command.id()))
                .orElseThrow(() -> new LibroNoEncontradoException(command.id()));

        libroRepository.delete(libro);
    }
}