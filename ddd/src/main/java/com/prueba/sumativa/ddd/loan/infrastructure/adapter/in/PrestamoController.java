package com.prueba.sumativa.ddd.loan.infrastructure.adapter.in;

import com.prueba.sumativa.ddd.loan.application.command.RegistrarDevolucionCommand;
import com.prueba.sumativa.ddd.loan.application.command.RegistrarPrestamoCommand;
import com.prueba.sumativa.ddd.loan.application.dto.PrestamoResponse;
import com.prueba.sumativa.ddd.loan.application.port.in.RegistrarDevolucionUseCase;
import com.prueba.sumativa.ddd.loan.application.port.in.RegistrarPrestamoUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final RegistrarPrestamoUseCase registrarPrestamoUseCase;
    private final RegistrarDevolucionUseCase registrarDevolucionUseCase;

    public PrestamoController(
            RegistrarPrestamoUseCase registrarPrestamoUseCase,
            RegistrarDevolucionUseCase registrarDevolucionUseCase) {

        this.registrarPrestamoUseCase = registrarPrestamoUseCase;
        this.registrarDevolucionUseCase = registrarDevolucionUseCase;
    }

    @PostMapping
    public PrestamoResponse registrarPrestamo(@RequestBody RegistrarPrestamoCommand command) {
        return registrarPrestamoUseCase.execute(command);
    }

    @PostMapping("/{id}/devolucion")
    public PrestamoResponse registrarDevolucion(@PathVariable Long id) {
        return registrarDevolucionUseCase.execute(new RegistrarDevolucionCommand(id));
    }
}