package com.prueba.sumativa.ddd.catalog.domain.repository;

import java.util.List;
import java.util.Optional;

import com.prueba.sumativa.ddd.catalog.domain.model.Libro;
import com.prueba.sumativa.ddd.catalog.domain.model.LibroId;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.ISBN;

public interface LibroRepository {
    Libro save(Libro libro);
    Optional<Libro> findById(LibroId id);
    List<Libro> findAll();
    boolean existsByISBN(ISBN isbn);
    void delete(Libro libro);
}
