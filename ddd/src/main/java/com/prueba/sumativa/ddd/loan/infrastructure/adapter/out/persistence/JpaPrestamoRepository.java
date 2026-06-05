package com.prueba.sumativa.ddd.loan.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.sumativa.ddd.loan.domain.valueObject.EstadoPrestamo;

public interface JpaPrestamoRepository extends JpaRepository<PrestamoEntity, Long> {
    long countByUsuarioIdAndEstado(Long usuarioId, EstadoPrestamo estado);
}
