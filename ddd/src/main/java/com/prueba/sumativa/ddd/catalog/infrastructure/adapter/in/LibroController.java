package com.prueba.sumativa.ddd.catalog.infrastructure.adapter.in;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.sumativa.ddd.catalog.application.command.ActualizarLibroCommand;
import com.prueba.sumativa.ddd.catalog.application.command.EliminarLibroCommand;
import com.prueba.sumativa.ddd.catalog.application.command.RegistrarLibroCommand;
import com.prueba.sumativa.ddd.catalog.application.dto.LibroResponse;
import com.prueba.sumativa.ddd.catalog.application.port.in.ActualizarLibroUseCase;
import com.prueba.sumativa.ddd.catalog.application.port.in.ConsultarLibrosUseCase;
import com.prueba.sumativa.ddd.catalog.application.port.in.EliminarLibroUseCase;
import com.prueba.sumativa.ddd.catalog.application.port.in.RegistrarLibroUseCase;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final RegistrarLibroUseCase registrarLibroUseCase;
    private final ConsultarLibrosUseCase consultarLibrosUseCase;
    private final EliminarLibroUseCase eliminarLibroUseCase;
    private final ActualizarLibroUseCase actualizarLibroUseCase;

    public LibroController(
            RegistrarLibroUseCase registrarLibroUseCase,
            ActualizarLibroUseCase actualizarLibroUseCase,
            ConsultarLibrosUseCase consultarLibrosUseCase,
            EliminarLibroUseCase eliminarLibroUseCase) {

        this.registrarLibroUseCase = registrarLibroUseCase;
        this.actualizarLibroUseCase = actualizarLibroUseCase;
        this.consultarLibrosUseCase = consultarLibrosUseCase;
        this.eliminarLibroUseCase = eliminarLibroUseCase;
    }

    @PostMapping
    public LibroResponse registrar(@RequestBody RegistrarLibroCommand command) {
        return registrarLibroUseCase.execute(
                command);
    }

    @GetMapping
    public List<LibroResponse> listar() {
        return consultarLibrosUseCase.execute();
    }

    @PutMapping("/{id}")
    public LibroResponse actualizar(@PathVariable Long id, @RequestBody ActualizarLibroCommand request) {
        return actualizarLibroUseCase.execute(
                new ActualizarLibroCommand(
                        id,
                        request.titulo(),
                        request.autor(),
                        request.anioPublicacion(),
                        request.cantidadDisponible()
                )
        );
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        eliminarLibroUseCase.execute(
                new EliminarLibroCommand(id)
        );
    }
}