package com.prueba.sumativa.ddd.catalog.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLibroRepository extends JpaRepository<LibroEntity, Long> {
    boolean existsByIsbn(String isbn);
}