package com.prueba.sumativa.ddd.user.application.dto;

public record UsuarioResponse(
        Long id,
        String nombre,
        String correo
) {}
