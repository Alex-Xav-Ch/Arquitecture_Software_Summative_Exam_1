package com.prueba.sumativa.ddd.user.infrastructure.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import com.prueba.sumativa.ddd.user.domain.model.Usuario;
import com.prueba.sumativa.ddd.user.domain.model.UsuarioId;
import com.prueba.sumativa.ddd.user.domain.repository.UsuarioRepository;
import com.prueba.sumativa.ddd.user.domain.valueObject.Correo;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final JpaUsuarioRepository repository;

    public UsuarioRepositoryAdapter(JpaUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = UsuarioPersistenceMapper.toEntity(usuario);
        UsuarioEntity saved = repository.save(entity);
        return UsuarioPersistenceMapper.toDomain(saved);
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll()
                .stream()
                .map(
                        UsuarioPersistenceMapper::toDomain
                )
                .toList();
    }

    @Override
    public boolean existsByCorreo(Correo correo) {
        return repository.existsByCorreo(correo.value());
    }

    @Override
    public Optional<Usuario> findById(UsuarioId id) {
        return repository.findById(id.value())
                .map(UsuarioPersistenceMapper::toDomain);
    }
}