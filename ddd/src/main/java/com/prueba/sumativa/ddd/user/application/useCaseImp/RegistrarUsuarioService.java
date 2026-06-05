package com.prueba.sumativa.ddd.user.application.useCaseImp;

import com.prueba.sumativa.ddd.user.application.command.RegistrarUsuarioCommand;
import com.prueba.sumativa.ddd.user.application.dto.UsuarioResponse;
import com.prueba.sumativa.ddd.user.application.port.in.RegistrarUsuarioUseCase;
import com.prueba.sumativa.ddd.user.domain.exception.CorreoDuplicadoException;
import com.prueba.sumativa.ddd.user.domain.model.Usuario;
import com.prueba.sumativa.ddd.user.domain.model.UsuarioFactory;
import com.prueba.sumativa.ddd.user.domain.repository.UsuarioRepository;
import com.prueba.sumativa.ddd.user.domain.valueObject.Correo;
import com.prueba.sumativa.ddd.user.domain.valueObject.Nombre;

public class RegistrarUsuarioService
        implements RegistrarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public RegistrarUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioResponse execute(RegistrarUsuarioCommand command) {
        Correo correo = new Correo(command.correo());

        if (usuarioRepository.existsByCorreo(correo)) {
            throw new CorreoDuplicadoException(correo.value());
        }

        Usuario usuario = UsuarioFactory.crearNuevo(new Nombre(command.nombre()), correo);

        Usuario saved = usuarioRepository.save(usuario);

        return map(saved);
    }

    private UsuarioResponse map(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId().value(),
                usuario.getNombre().value(),
                usuario.getCorreo().value()
        );
    }
}