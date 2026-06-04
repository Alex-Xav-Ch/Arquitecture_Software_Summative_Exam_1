package com.prueba.sumativa.layered_monolith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.sumativa.layered_monolith.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    boolean existsByIsbn(String isbn);
}
