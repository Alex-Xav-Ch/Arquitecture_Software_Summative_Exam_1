package com.prueba.sumativa.ddd.loan.infrastructure.adapter.in;

import com.prueba.sumativa.ddd.loan.application.command.RegistrarDevolucionCommand;
import com.prueba.sumativa.ddd.loan.application.command.RegistrarPrestamoCommand;
import com.prueba.sumativa.ddd.loan.application.dto.PrestamoResponse;
import com.prueba.sumativa.ddd.loan.application.port.in.ConsultarPrestamosUseCase;
import com.prueba.sumativa.ddd.loan.application.port.in.RegistrarDevolucionUseCase;
import com.prueba.sumativa.ddd.loan.application.port.in.RegistrarPrestamoUseCase;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final RegistrarPrestamoUseCase registrarPrestamoUseCase;
    private final RegistrarDevolucionUseCase registrarDevolucionUseCase;
    private final ConsultarPrestamosUseCase consultarPrestamosUseCase;

    public PrestamoController(
            RegistrarPrestamoUseCase registrarPrestamoUseCase,
            RegistrarDevolucionUseCase registrarDevolucionUseCase,
            ConsultarPrestamosUseCase consultarPrestamosUseCase) {

        this.registrarPrestamoUseCase = registrarPrestamoUseCase;
        this.registrarDevolucionUseCase = registrarDevolucionUseCase;
        this.consultarPrestamosUseCase = consultarPrestamosUseCase;
    }

    @PostMapping
    public PrestamoResponse registrarPrestamo(@RequestBody RegistrarPrestamoCommand command) {
        return registrarPrestamoUseCase.execute(command);
    }

    @PostMapping("/{id}/devolucion")
    public PrestamoResponse registrarDevolucion(@PathVariable Long id) {
        return registrarDevolucionUseCase.execute(new RegistrarDevolucionCommand(id));
    }

    @GetMapping
    public List<PrestamoResponse> obtenerTodos() {
        return consultarPrestamosUseCase.execute();
    }
}