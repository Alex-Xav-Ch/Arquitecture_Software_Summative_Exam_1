package com.prueba.sumativa.ddd.user.domain.model;

import com.prueba.sumativa.ddd.user.domain.valueObject.Correo;
import com.prueba.sumativa.ddd.user.domain.valueObject.Nombre;

public final class UsuarioFactory {

    private UsuarioFactory() {}

    public static Usuario crearNuevo(
            Nombre nombre,
            Correo correo) {

        return new Usuario(
                null,
                nombre,
                correo
        );
    }

    public static Usuario actualizar(
            UsuarioId id,
            Nombre nombre,
            Correo correo

    ) {
        return new Usuario(
                id,
                nombre,
                correo
        );
    }
}