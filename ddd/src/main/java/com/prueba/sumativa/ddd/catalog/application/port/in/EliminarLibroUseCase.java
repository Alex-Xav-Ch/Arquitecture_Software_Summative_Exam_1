package com.prueba.sumativa.ddd.catalog.application.port.in;

import com.prueba.sumativa.ddd.catalog.application.command.EliminarLibroCommand;

public interface EliminarLibroUseCase {
    void execute(EliminarLibroCommand command);
}