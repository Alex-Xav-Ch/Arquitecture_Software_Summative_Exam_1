package com.prueba.sumativa.ddd.loan.infrastructure.adapter.out.persistence;

import com.prueba.sumativa.ddd.loan.domain.model.Prestamo;
import com.prueba.sumativa.ddd.loan.domain.model.PrestamoId;
import com.prueba.sumativa.ddd.loan.domain.repository.PrestamoRepository;
import com.prueba.sumativa.ddd.loan.domain.valueObject.EstadoPrestamo;
import com.prueba.sumativa.ddd.loan.domain.valueObject.UsuarioId;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PrestamoRepositoryAdapter implements PrestamoRepository {

    private final JpaPrestamoRepository repository;

    public PrestamoRepositoryAdapter(
            JpaPrestamoRepository repository) {

        this.repository = repository;
    }

    @Override
    public Prestamo save(
            Prestamo prestamo) {

        PrestamoEntity entity =
                PrestamoPersistenceMapper.toEntity(
                        prestamo);

        PrestamoEntity saved =
                repository.save(entity);

        return PrestamoPersistenceMapper.toDomain(
                saved);
    }

    @Override
    public Optional<Prestamo> findById(
            PrestamoId id) {

        return repository.findById(
                        id.value())
                .map(
                        PrestamoPersistenceMapper::toDomain
                );
    }

    @Override
    public long countPrestamosActivos(
            UsuarioId usuarioId) {

        return repository.countByUsuarioIdAndEstado(
                usuarioId.value(),
                EstadoPrestamo.ACTIVO
        );
    }

    @Override
        public List<Prestamo> findAll() {
        return repository.findAll()
                .stream()
                .map(PrestamoPersistenceMapper::toDomain)
                .toList();
        }
}