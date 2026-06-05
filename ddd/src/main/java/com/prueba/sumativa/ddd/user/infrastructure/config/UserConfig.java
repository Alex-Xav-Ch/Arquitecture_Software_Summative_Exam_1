package com.prueba.sumativa.ddd.user.infrastructure.config;

import com.prueba.sumativa.ddd.user.application.port.in.ConsultarUsuariosUseCase;
import com.prueba.sumativa.ddd.user.application.port.in.RegistrarUsuarioUseCase;
import com.prueba.sumativa.ddd.user.application.useCaseImp.ConsultarUsuariosService;
import com.prueba.sumativa.ddd.user.application.useCaseImp.RegistrarUsuarioService;
import com.prueba.sumativa.ddd.user.domain.repository.UsuarioRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public RegistrarUsuarioUseCase registrarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        return new RegistrarUsuarioService(usuarioRepository);
    }

    @Bean
    public ConsultarUsuariosUseCase consultarUsuariosUseCase(UsuarioRepository usuarioRepository) {
        return new ConsultarUsuariosService(usuarioRepository);
    }
}