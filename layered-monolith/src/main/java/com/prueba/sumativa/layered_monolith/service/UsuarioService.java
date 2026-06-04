package com.prueba.sumativa.layered_monolith.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.sumativa.layered_monolith.entity.Usuario;
import com.prueba.sumativa.layered_monolith.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario crear(Usuario u) {
        if (repo.existsByCorreo(u.getCorreo())) {
            throw new RuntimeException("Correo ya existe");
        }

        return repo.save(u);
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }
}