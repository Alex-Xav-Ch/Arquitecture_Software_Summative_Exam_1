package com.prueba.sumativa.ddd.user.application.useCaseImp;

import com.prueba.sumativa.ddd.user.application.dto.UsuarioResponse;
import com.prueba.sumativa.ddd.user.application.port.in.ConsultarUsuariosUseCase;
import com.prueba.sumativa.ddd.user.domain.repository.UsuarioRepository;

import java.util.List;

public class ConsultarUsuariosService
        implements ConsultarUsuariosUseCase {

    private final UsuarioRepository usuarioRepository;

    public ConsultarUsuariosService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioResponse> execute() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario ->
                        new UsuarioResponse(
                                usuario.getId().value(),
                                usuario.getNombre().value(),
                                usuario.getCorreo().value()
                        )
                )
                .toList();
    }
}
