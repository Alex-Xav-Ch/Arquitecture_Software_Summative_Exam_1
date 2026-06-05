package com.prueba.sumativa.ddd.loan.application.command;

public record RegistrarPrestamoCommand(
        Long libroId,
        Long usuarioId
) {}
