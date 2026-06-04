package com.prueba.sumativa.spaguetti_web;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @PersistenceContext
    private EntityManager em;

    /* ================LIBROS================ */

    @PostMapping("/libros")
    @Transactional
    public ResponseEntity<?> registrarLibro(@RequestBody Libro libro) {

        // RN-06: ISBN único
        List<Libro> existe = em.createQuery(
                "FROM Libro l WHERE l.isbn = :isbn", Libro.class)
                .setParameter("isbn", libro.getIsbn())
                .getResultList();

        if (!existe.isEmpty()) {
            return ResponseEntity.badRequest().body("ISBN ya existe");
        }

        em.persist(libro);
        return ResponseEntity.ok(libro);
    }

    @GetMapping("/libros")
    public List<Libro> listarLibros() {
        return em.createQuery("FROM Libro", Libro.class).getResultList();
    }

    @PutMapping("/libros/{id}")
    @Transactional
    public ResponseEntity<?> actualizarLibro(@PathVariable Long id,
                                             @RequestBody Libro data) {

        Libro libro = em.find(Libro.class, id);

        if (libro == null) {
            return ResponseEntity.badRequest().body("Libro no existe");
        }

        libro.setTitulo(data.getTitulo());
        libro.setAutor(data.getAutor());
        libro.setAnioPublicacion(data.getAnioPublicacion());
        libro.setCantidadDisponible(data.getCantidadDisponible());

        return ResponseEntity.ok(libro);
    }

    @DeleteMapping("/libros/{id}")
    @Transactional
    public ResponseEntity<?> eliminarLibro(@PathVariable Long id) {

        // RN-05: no eliminar si tiene préstamos activos
        Long count = em.createQuery(
                "SELECT COUNT(p) FROM Prestamo p WHERE p.libroId = :id AND p.estado = 'ACTIVO'",
                Long.class)
                .setParameter("id", id)
                .getSingleResult();

        if (count > 0) {
            return ResponseEntity.badRequest().body("Libro tiene préstamos activos");
        }

        Libro libro = em.find(Libro.class, id);

        if (libro != null) {
            em.remove(libro);
        }

        return ResponseEntity.ok("Libro eliminado");
    }

    /* ================USUARIOS================ */

    @PostMapping("/usuarios")
    @Transactional
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario u) {

        // RN-07: correo único
        List<Usuario> existe = em.createQuery(
                "FROM Usuario u WHERE u.correo = :correo", Usuario.class)
                .setParameter("correo", u.getCorreo())
                .getResultList();

        if (!existe.isEmpty()) {
            return ResponseEntity.badRequest().body("Correo ya existe");
        }

        em.persist(u);
        return ResponseEntity.ok(u);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return em.createQuery("FROM Usuario", Usuario.class).getResultList();
    }

    @DeleteMapping("/usuarios/{id}")
    @Transactional
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {

        Long activos = em.createQuery(
                "SELECT COUNT(p) FROM Prestamo p WHERE p.usuarioId = :id AND p.estado = 'ACTIVO'",
                Long.class)
                .setParameter("id", id)
                .getSingleResult();

        if (activos > 0) {
            return ResponseEntity.badRequest().body("Usuario tiene préstamos activos");
        }

        Usuario u = em.find(Usuario.class, id);
        if (u != null) em.remove(u);

        return ResponseEntity.ok("Usuario eliminado");
    }

    /* ================PRÉSTAMOS================ */

    @PostMapping("/prestamos")
    @Transactional
    public ResponseEntity<?> prestarLibro(@RequestParam Long usuarioId,
                                          @RequestParam Long libroId) {

        Usuario usuario = em.find(Usuario.class, usuarioId);
        Libro libro = em.find(Libro.class, libroId);

        if (usuario == null || libro == null) {
            return ResponseEntity.badRequest().body("Usuario o libro no existe");
        }

        // RN-01: Validar disponibilidad
        if (libro.getCantidadDisponible() <= 0) {
            return ResponseEntity.badRequest().body("Sin ejemplares disponibles");
        }

        // RN-04: max 3 préstamos activos
        Long activos = em.createQuery(
                "SELECT COUNT(p) FROM Prestamo p WHERE p.usuarioId = :uid AND p.estado = 'ACTIVO'",
                Long.class)
                .setParameter("uid", usuarioId)
                .getSingleResult();

        if (activos >= 3) {
            return ResponseEntity.badRequest().body("Máximo 3 préstamos");
        }

        // RN-02: disminuir stock
        libro.setCantidadDisponible(libro.getCantidadDisponible() - 1);

        Prestamo p = new Prestamo();
        p.setUsuarioId(usuarioId);
        p.setLibroId(libroId);
        p.setEstado("ACTIVO");
        p.setFechaPrestamo(LocalDate.now());
        p.setFechaDevolucion(LocalDate.now().plusDays(7));

        em.persist(p);

        return ResponseEntity.ok(p);
    }

    @PutMapping("/prestamos/{id}/devolver")
    @Transactional
    public ResponseEntity<?> devolver(@PathVariable Long id) {

        Prestamo p = em.find(Prestamo.class, id);

        if (p == null) {
            return ResponseEntity.badRequest().body("Préstamo no existe");
        }

        if ("DEVUELTO".equals(p.getEstado())) {
            return ResponseEntity.badRequest().body("Ya fue devuelto");
        }

        Libro libro = em.find(Libro.class, p.getLibroId());

        // RN-03: aumentar stock
        libro.setCantidadDisponible(libro.getCantidadDisponible() + 1);

        p.setEstado("DEVUELTO");

        return ResponseEntity.ok("Devuelto correctamente");
    }

    @GetMapping("/prestamos/activos")
    public List<Prestamo> prestamosActivos() {
        return em.createQuery(
                "FROM Prestamo p WHERE p.estado = 'ACTIVO'",
                Prestamo.class
        ).getResultList();
    }
}
