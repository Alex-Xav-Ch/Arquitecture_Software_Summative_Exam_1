package com.prueba.sumativa.ddd.catalog.application.useCaseImp;

import java.util.List;

import com.prueba.sumativa.ddd.catalog.application.dto.LibroResponse;
import com.prueba.sumativa.ddd.catalog.application.port.in.ConsultarLibrosUseCase;
import com.prueba.sumativa.ddd.catalog.domain.repository.LibroRepository;

public class ConsultarLibrosService implements ConsultarLibrosUseCase {

    private final LibroRepository libroRepository;

    public ConsultarLibrosService(
            LibroRepository libroRepository) {

        this.libroRepository = libroRepository;
    }

    @Override
    public List<LibroResponse> execute() {

        return libroRepository.findAll()
                .stream()
                .map(libro -> new LibroResponse(
                        libro.getId().value(),
                        libro.getIsbn().value(),
                        libro.getTitulo(),
                        libro.getAutor(),
                        libro.getAnioPublicacion().value(),
                        libro.getCantidadDisponible().value()
                ))
                .toList();
    }
}
