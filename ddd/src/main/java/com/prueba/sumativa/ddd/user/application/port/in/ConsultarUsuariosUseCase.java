package com.prueba.sumativa.ddd.user.application.port.in;
import java.util.List;

import com.prueba.sumativa.ddd.user.application.dto.UsuarioResponse;

public interface ConsultarUsuariosUseCase {
    List<UsuarioResponse> execute();
}
