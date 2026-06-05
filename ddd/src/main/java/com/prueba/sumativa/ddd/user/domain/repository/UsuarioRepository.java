package com.prueba.sumativa.ddd.user.domain.repository;

import java.util.List;
import java.util.Optional;

import com.prueba.sumativa.ddd.loan.domain.valueObject.UsuarioId;
import com.prueba.sumativa.ddd.user.domain.model.Usuario;
import com.prueba.sumativa.ddd.user.domain.valueObject.Correo;

public interface UsuarioRepository {
    Optional<Usuario> findById(UsuarioId id);
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    boolean existsByCorreo(Correo correo);
}