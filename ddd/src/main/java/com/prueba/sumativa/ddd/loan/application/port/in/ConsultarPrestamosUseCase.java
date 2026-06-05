package com.prueba.sumativa.ddd.loan.application.port.in;

import java.util.List;

import com.prueba.sumativa.ddd.loan.application.dto.PrestamoResponse;

public interface ConsultarPrestamosUseCase {
    List<PrestamoResponse> execute();
}
