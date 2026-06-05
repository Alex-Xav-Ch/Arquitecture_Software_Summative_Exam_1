package com.prueba.sumativa.ddd.loan.application.port.in;

import com.prueba.sumativa.ddd.loan.application.command.RegistrarDevolucionCommand;
import com.prueba.sumativa.ddd.loan.application.dto.PrestamoResponse;

public interface RegistrarDevolucionUseCase {
    PrestamoResponse execute(RegistrarDevolucionCommand command);
}
