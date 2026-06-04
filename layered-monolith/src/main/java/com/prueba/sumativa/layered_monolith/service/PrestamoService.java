package com.prueba.sumativa.layered_monolith.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.sumativa.layered_monolith.entity.Libro;
import com.prueba.sumativa.layered_monolith.entity.Prestamo;
import com.prueba.sumativa.layered_monolith.entity.Usuario;
import com.prueba.sumativa.layered_monolith.repository.LibroRepository;
import com.prueba.sumativa.layered_monolith.repository.PrestamoRepository;
import com.prueba.sumativa.layered_monolith.repository.UsuarioRepository;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepo;

    @Autowired
    private LibroRepository libroRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    public Prestamo prestar(Long usuarioId, Long libroId) {

        Usuario usuario = usuarioRepo.findById(usuarioId)
                .orElseThrow();

        Libro libro = libroRepo.findById(libroId)
                .orElseThrow();

        if (libro.getCantidadDisponible() <= 0)
            throw new RuntimeException("Sin stock");

        if (prestamoRepo.countByUsuarioIdAndEstado(usuarioId, "ACTIVO") >= 3)
            throw new RuntimeException("Máximo 3 préstamos");

        libro.setCantidadDisponible(libro.getCantidadDisponible() - 1);
        libroRepo.save(libro);

        Prestamo p = new Prestamo();
        p.setUsuarioId(usuarioId);
        p.setLibroId(libroId);
        p.setEstado("ACTIVO");
        p.setFechaPrestamo(LocalDate.now());
        p.setFechaDevolucion(LocalDate.now().plusDays(7));

        return prestamoRepo.save(p);
    }

    public Prestamo devolver(Long id) {

        Prestamo prestamo = prestamoRepo.findById(id)
                .orElseThrow();

        if (!prestamo.getEstado().equals("ACTIVO"))
            throw new RuntimeException("Ya devuelto");

        Libro libro = libroRepo.findById(prestamo.getLibroId()).orElseThrow();

        libro.setCantidadDisponible(libro.getCantidadDisponible() + 1);
        libroRepo.save(libro);

        prestamo.setEstado("DEVUELTO");

        return prestamoRepo.save(prestamo);
    }

    public List<Prestamo> activos() {
        return prestamoRepo.findByEstado("ACTIVO");
    }
}