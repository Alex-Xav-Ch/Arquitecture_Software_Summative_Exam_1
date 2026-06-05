package com.prueba.sumativa.ddd.loan.domain.repository;

import java.util.List;
import java.util.Optional;

import com.prueba.sumativa.ddd.loan.domain.model.Prestamo;
import com.prueba.sumativa.ddd.loan.domain.model.PrestamoId;
import com.prueba.sumativa.ddd.loan.domain.valueObject.UsuarioId;

public interface PrestamoRepository {
    List<Prestamo> findAll();
    Prestamo save(Prestamo prestamo);
    Optional<Prestamo> findById(PrestamoId id);
    long countPrestamosActivos(UsuarioId usuarioId);
}
