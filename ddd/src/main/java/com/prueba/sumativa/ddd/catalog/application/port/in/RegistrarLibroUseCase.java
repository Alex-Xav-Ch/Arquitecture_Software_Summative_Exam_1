package com.prueba.sumativa.ddd.catalog.application.port.in;

import com.prueba.sumativa.ddd.catalog.application.command.RegistrarLibroCommand;
import com.prueba.sumativa.ddd.catalog.application.dto.LibroResponse;

public interface RegistrarLibroUseCase {

    LibroResponse execute(
        RegistrarLibroCommand command
    );

}