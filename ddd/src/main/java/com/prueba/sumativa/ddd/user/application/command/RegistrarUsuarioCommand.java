package com.prueba.sumativa.ddd.user.application.command;

public record RegistrarUsuarioCommand(
        String nombre,
        String correo
) {}