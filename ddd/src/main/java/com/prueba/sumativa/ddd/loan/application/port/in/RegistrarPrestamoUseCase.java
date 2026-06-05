package com.prueba.sumativa.ddd.loan.application.port.in;

import com.prueba.sumativa.ddd.loan.application.command.RegistrarPrestamoCommand;
import com.prueba.sumativa.ddd.loan.application.dto.PrestamoResponse;

public interface RegistrarPrestamoUseCase {
    PrestamoResponse execute(RegistrarPrestamoCommand command);
}
