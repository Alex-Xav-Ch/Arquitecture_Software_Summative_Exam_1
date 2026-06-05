package com.prueba.sumativa.ddd.user.domain.model;

import com.prueba.sumativa.ddd.user.domain.valueObject.Nombre;
import com.prueba.sumativa.ddd.user.domain.valueObject.Correo;

public class Usuario {

    private UsuarioId id;
    private Nombre nombre;
    private Correo correo;

    protected Usuario(
            UsuarioId id,
            Nombre nombre,
            Correo correo) {

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public UsuarioId getId() {
        return id;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Correo getCorreo() {
        return correo;
    }
}