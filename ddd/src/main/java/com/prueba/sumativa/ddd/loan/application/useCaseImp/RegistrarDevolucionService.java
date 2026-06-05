package com.prueba.sumativa.ddd.loan.application.useCaseImp;

import com.prueba.sumativa.ddd.loan.application.command.RegistrarDevolucionCommand;
import com.prueba.sumativa.ddd.loan.application.dto.PrestamoResponse;
import com.prueba.sumativa.ddd.loan.application.port.in.RegistrarDevolucionUseCase;
import com.prueba.sumativa.ddd.loan.application.port.out.CatalogPort;
import com.prueba.sumativa.ddd.loan.domain.exception.PrestamoNoEncontradoException;
import com.prueba.sumativa.ddd.loan.domain.model.Prestamo;
import com.prueba.sumativa.ddd.loan.domain.model.PrestamoId;
import com.prueba.sumativa.ddd.loan.domain.repository.PrestamoRepository;

public class RegistrarDevolucionService
        implements RegistrarDevolucionUseCase {

    private final PrestamoRepository prestamoRepository;
    private final CatalogPort catalogPort;

    public RegistrarDevolucionService(
            PrestamoRepository prestamoRepository,
            CatalogPort catalogPort) {

        this.prestamoRepository = prestamoRepository;
        this.catalogPort = catalogPort;
    }

    @Override
    public PrestamoResponse execute(RegistrarDevolucionCommand command) {

        Prestamo prestamo = prestamoRepository.findById(
                                new PrestamoId(command.prestamoId()))
                        .orElseThrow(() -> new PrestamoNoEncontradoException(command.prestamoId()));

        prestamo.devolver();
        Prestamo updated = prestamoRepository.save(prestamo);
        catalogPort.aumentarDisponibilidad(prestamo.getLibroId().value());

        return map(updated);
    }

    private PrestamoResponse map(Prestamo prestamo) {
        return new PrestamoResponse(
                prestamo.getId().value(),
                prestamo.getLibroId().value(),
                prestamo.getUsuarioId().value(),
                prestamo.getFechaPrestamo().value(),
                prestamo.getFechaDevolucion().value(),
                prestamo.getEstado()
        );
    }
}
