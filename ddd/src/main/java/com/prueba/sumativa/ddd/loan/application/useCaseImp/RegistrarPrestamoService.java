package com.prueba.sumativa.ddd.loan.application.useCaseImp;

import com.prueba.sumativa.ddd.loan.application.command.RegistrarPrestamoCommand;
import com.prueba.sumativa.ddd.loan.application.dto.PrestamoResponse;
import com.prueba.sumativa.ddd.loan.application.port.in.RegistrarPrestamoUseCase;
import com.prueba.sumativa.ddd.loan.application.port.out.CatalogPort;
import com.prueba.sumativa.ddd.loan.application.port.out.UserPort;
import com.prueba.sumativa.ddd.loan.domain.exception.LibroNoDisponibleException;
import com.prueba.sumativa.ddd.loan.domain.model.*;
import com.prueba.sumativa.ddd.loan.domain.repository.PrestamoRepository;
import com.prueba.sumativa.ddd.loan.domain.service.PrestamoDomainService;
import com.prueba.sumativa.ddd.loan.domain.valueObject.LibroId;
import com.prueba.sumativa.ddd.loan.domain.valueObject.UsuarioId;

public class RegistrarPrestamoService implements RegistrarPrestamoUseCase {

    private final PrestamoRepository prestamoRepository;
    private final CatalogPort catalogPort;
    private final UserPort userPort;
    private final PrestamoDomainService prestamoDomainService;

    public RegistrarPrestamoService(
            PrestamoRepository prestamoRepository,
            CatalogPort catalogPort,
            UserPort userPort,
            PrestamoDomainService prestamoDomainService) {

        this.prestamoRepository = prestamoRepository;
        this.catalogPort = catalogPort;
        this.userPort = userPort;
        this.prestamoDomainService = prestamoDomainService;
    }

    @Override
    public PrestamoResponse execute(RegistrarPrestamoCommand command) {
        if (!userPort.existeUsuario(command.usuarioId())) {
            throw new IllegalArgumentException("Usuario no existe");
        }

        if (!catalogPort.libroDisponible(command.libroId())) {
            throw new LibroNoDisponibleException();
        }

        long prestamosActivos = prestamoRepository
                                .countPrestamosActivos(new UsuarioId(command.usuarioId()));

        prestamoDomainService.validarLimitePrestamos(prestamosActivos);

        Prestamo prestamo = PrestamoFactory.crearNuevo(
                                new LibroId(command.libroId()),
                                new UsuarioId(command.usuarioId())
                            );

        Prestamo saved = prestamoRepository.save(prestamo);

        catalogPort.disminuirDisponibilidad(command.libroId());

        return map(saved);
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