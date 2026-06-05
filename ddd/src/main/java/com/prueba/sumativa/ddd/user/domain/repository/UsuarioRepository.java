package com.prueba.sumativa.ddd.user.domain.repository;

import java.util.List;

import com.prueba.sumativa.ddd.user.domain.model.Usuario;
import com.prueba.sumativa.ddd.user.domain.valueObject.Correo;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    boolean existsByCorreo(Correo correo);
}