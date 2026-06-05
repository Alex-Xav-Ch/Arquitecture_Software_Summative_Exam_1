package com.prueba.sumativa.ddd.user.application.port.in;

import com.prueba.sumativa.ddd.user.application.command.RegistrarUsuarioCommand;
import com.prueba.sumativa.ddd.user.application.dto.UsuarioResponse;

public interface RegistrarUsuarioUseCase {
    UsuarioResponse execute(RegistrarUsuarioCommand command);
}