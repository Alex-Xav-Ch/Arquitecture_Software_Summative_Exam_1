package com.prueba.sumativa.ddd.loan.infrastructure.adapter.out.catalog;

import com.prueba.sumativa.ddd.catalog.domain.model.Libro;
import com.prueba.sumativa.ddd.catalog.domain.model.LibroId;
import com.prueba.sumativa.ddd.catalog.domain.repository.LibroRepository;
import com.prueba.sumativa.ddd.loan.application.port.out.CatalogPort;
import org.springframework.stereotype.Component;

@Component
public class CatalogAdapter implements CatalogPort {

    private final LibroRepository libroRepository;

    public CatalogAdapter(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public boolean libroDisponible(Long libroId) {
        return libroRepository
                .findById(new LibroId(libroId))
                .map(libro -> libro.getCantidadDisponible().value() > 0)
                .orElse(false);
    }

    @Override
    public void disminuirDisponibilidad(Long libroId) {
        Libro libro = libroRepository.findById(new LibroId(libroId))
                        .orElseThrow();
        libro.disminuirDisponibilidad();
        libroRepository.save(libro);
    }

    @Override
    public void aumentarDisponibilidad(Long libroId) {
        Libro libro = libroRepository.findById(new LibroId(libroId))
                        .orElseThrow();
        libro.incrementarDisponibilidad();
        libroRepository.save(libro);
    }
}
