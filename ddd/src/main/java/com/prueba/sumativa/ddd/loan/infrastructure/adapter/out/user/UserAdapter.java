package com.prueba.sumativa.ddd.loan.infrastructure.adapter.out.user;

import com.prueba.sumativa.ddd.loan.application.port.out.UserPort;
import com.prueba.sumativa.ddd.loan.domain.valueObject.UsuarioId;
import com.prueba.sumativa.ddd.user.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter implements UserPort {

    private final UsuarioRepository usuarioRepository;

    public UserAdapter(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public boolean existeUsuario(Long usuarioId) {
        return usuarioRepository.findById(new UsuarioId(usuarioId)).isPresent();
    }
}