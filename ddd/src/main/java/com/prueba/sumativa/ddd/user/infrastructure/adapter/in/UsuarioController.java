package com.prueba.sumativa.ddd.user.infrastructure.adapter.in;

import com.prueba.sumativa.ddd.user.application.command.RegistrarUsuarioCommand;
import com.prueba.sumativa.ddd.user.application.dto.UsuarioResponse;
import com.prueba.sumativa.ddd.user.application.port.in.ConsultarUsuariosUseCase;
import com.prueba.sumativa.ddd.user.application.port.in.RegistrarUsuarioUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;
    private final ConsultarUsuariosUseCase consultarUsuariosUseCase;

    public UsuarioController(
            RegistrarUsuarioUseCase registrarUsuarioUseCase,
            ConsultarUsuariosUseCase consultarUsuariosUseCase) {

        this.registrarUsuarioUseCase = registrarUsuarioUseCase;
        this.consultarUsuariosUseCase = consultarUsuariosUseCase;
    }

    @PostMapping
    public UsuarioResponse registrar(@RequestBody RegistrarUsuarioCommand command) {
        return registrarUsuarioUseCase.execute(command);
    }

    @GetMapping
    public List<UsuarioResponse> listar() {
        return consultarUsuariosUseCase.execute();
    }
}