package com.prueba.sumativa.layered_monolith.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.sumativa.layered_monolith.entity.Libro;
import com.prueba.sumativa.layered_monolith.repository.LibroRepository;

@Service
public class LibroService {

    @Autowired
    private LibroRepository repo;

    public Libro crear(Libro libro) {
        if (repo.existsByIsbn(libro.getIsbn())) {
            throw new RuntimeException("ISBN ya existe");
        }

        libro.setCantidadDisponible(1);
        return repo.save(libro);
    }

    public List<Libro> listar() {
        return repo.findAll();
    }

    public Libro actualizar(Long id, Libro data) {
        Libro libro = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe"));

        libro.setTitulo(data.getTitulo());
        libro.setAutor(data.getAutor());
        libro.setAnioPublicacion(data.getAnioPublicacion());
        libro.setCantidadDisponible(data.getCantidadDisponible());

        return repo.save(libro);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
