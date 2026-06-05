package com.prueba.sumativa.ddd.catalog.application.port.in;

import com.prueba.sumativa.ddd.catalog.application.command.ActualizarLibroCommand;
import com.prueba.sumativa.ddd.catalog.application.dto.LibroResponse;

public interface ActualizarLibroUseCase {
    LibroResponse execute(ActualizarLibroCommand command);
}
