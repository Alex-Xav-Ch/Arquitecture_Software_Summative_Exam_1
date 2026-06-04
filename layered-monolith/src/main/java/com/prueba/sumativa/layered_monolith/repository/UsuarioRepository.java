package com.prueba.sumativa.layered_monolith.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.sumativa.layered_monolith.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCorreo(String correo);
}
