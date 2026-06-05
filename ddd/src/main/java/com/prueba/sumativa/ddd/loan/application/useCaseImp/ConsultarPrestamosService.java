package com.prueba.sumativa.ddd.loan.application.useCaseImp;

import com.prueba.sumativa.ddd.loan.application.dto.PrestamoResponse;
import com.prueba.sumativa.ddd.loan.application.port.in.ConsultarPrestamosUseCase;

import java.util.List;

import com.prueba.sumativa.ddd.loan.domain.repository.PrestamoRepository;

public class ConsultarPrestamosService implements ConsultarPrestamosUseCase {

    private final PrestamoRepository prestamoRepository;

    public ConsultarPrestamosService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public List<PrestamoResponse> execute() {
        return prestamoRepository.findAll()
                .stream()
                .map(PrestamoResponse::from)
                .toList();
    }
}