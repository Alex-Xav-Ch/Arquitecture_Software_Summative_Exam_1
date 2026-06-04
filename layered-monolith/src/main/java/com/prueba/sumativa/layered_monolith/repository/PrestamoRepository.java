package com.prueba.sumativa.layered_monolith.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.sumativa.layered_monolith.entity.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    long countByUsuarioIdAndEstado(Long usuarioId, String estado);
    List<Prestamo> findByEstado(String estado);
}
