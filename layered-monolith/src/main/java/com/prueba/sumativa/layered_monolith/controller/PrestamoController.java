package com.prueba.sumativa.layered_monolith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.sumativa.layered_monolith.entity.Prestamo;
import com.prueba.sumativa.layered_monolith.service.PrestamoService;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping
    public Prestamo prestar(@RequestParam Long usuarioId,
                            @RequestParam Long libroId) {
        return prestamoService.prestar(usuarioId, libroId);
    }

    @PutMapping("/{id}/devolver")
    public Prestamo devolver(@PathVariable Long id) {
        return prestamoService.devolver(id);
    }

    @GetMapping("/activos")
    public List<Prestamo> activos() {
        return prestamoService.activos();
    }
}