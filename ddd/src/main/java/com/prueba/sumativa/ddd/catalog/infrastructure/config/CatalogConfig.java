package com.prueba.sumativa.ddd.catalog.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prueba.sumativa.ddd.catalog.application.port.in.ActualizarLibroUseCase;
import com.prueba.sumativa.ddd.catalog.application.port.in.ConsultarLibrosUseCase;
import com.prueba.sumativa.ddd.catalog.application.port.in.EliminarLibroUseCase;
import com.prueba.sumativa.ddd.catalog.application.port.in.RegistrarLibroUseCase;
import com.prueba.sumativa.ddd.catalog.application.useCaseImp.ActualizarLibroService;
import com.prueba.sumativa.ddd.catalog.application.useCaseImp.ConsultarLibrosService;
import com.prueba.sumativa.ddd.catalog.application.useCaseImp.EliminarLibroService;
import com.prueba.sumativa.ddd.catalog.application.useCaseImp.RegistrarLibroService;
import com.prueba.sumativa.ddd.catalog.domain.repository.LibroRepository;

@Configuration
public class CatalogConfig {

    @Bean
    RegistrarLibroUseCase registrarLibroUseCase(LibroRepository repository) {
        return new RegistrarLibroService(repository);
    }

    @Bean
    ActualizarLibroUseCase actualizarLibroUseCase(LibroRepository repository) {
        return new ActualizarLibroService(repository);
    }

    @Bean
    ConsultarLibrosUseCase consultarLibrosUseCase(LibroRepository repository) {
        return new ConsultarLibrosService(repository);
    }

    @Bean
    EliminarLibroUseCase eliminarLibroUseCase(LibroRepository repository) {
        return new EliminarLibroService(repository);
    }
}