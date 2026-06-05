package com.prueba.sumativa.ddd.catalog.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.prueba.sumativa.ddd.catalog.domain.model.Libro;
import com.prueba.sumativa.ddd.catalog.domain.model.LibroId;
import com.prueba.sumativa.ddd.catalog.domain.repository.LibroRepository;
import com.prueba.sumativa.ddd.catalog.domain.valueObject.ISBN;

@Repository
public class LibroRepositoryAdapter implements LibroRepository {

    private final JpaLibroRepository repository;

    public LibroRepositoryAdapter(JpaLibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public Libro save(Libro libro) {
        LibroEntity entity = LibroPersistenceMapper.toEntity(libro);
        LibroEntity saved = repository.save(entity);
        return LibroPersistenceMapper.toDomain(saved);
    }

    @Override
    public Optional<Libro> findById(LibroId id) {
        return repository.findById(id.value())
                .map(LibroPersistenceMapper::toDomain);
    }

    @Override
    public List<Libro> findAll() {
        return repository.findAll()
                .stream()
                .map(LibroPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByISBN(ISBN isbn) {
        return repository.existsByIsbn(isbn.value());
    }

    @Override
    public void delete(Libro libro) {
        repository.deleteById(libro.getId().value());
    }
}