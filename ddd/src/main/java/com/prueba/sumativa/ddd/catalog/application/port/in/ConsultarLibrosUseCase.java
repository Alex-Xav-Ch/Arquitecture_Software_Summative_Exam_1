package com.prueba.sumativa.ddd.catalog.application.port.in;

import java.util.List;

import com.prueba.sumativa.ddd.catalog.application.dto.LibroResponse;

public interface ConsultarLibrosUseCase {
    List<LibroResponse> execute();
}