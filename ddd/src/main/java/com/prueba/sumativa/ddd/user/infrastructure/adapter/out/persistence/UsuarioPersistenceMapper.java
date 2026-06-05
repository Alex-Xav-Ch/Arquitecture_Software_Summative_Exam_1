package com.prueba.sumativa.ddd.user.infrastructure.adapter.out.persistence;

import com.prueba.sumativa.ddd.user.domain.model.*;
import com.prueba.sumativa.ddd.user.domain.valueObject.Correo;
import com.prueba.sumativa.ddd.user.domain.valueObject.Nombre;

public final class UsuarioPersistenceMapper {

    private UsuarioPersistenceMapper() {}

    public static UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
                usuario.getId() != null
                        ? usuario.getId().value()
                        : null,
                usuario.getNombre().value(),
                usuario.getCorreo().value()
        );
    }

    public static Usuario toDomain(UsuarioEntity entity) {
        return  UsuarioFactory.actualizar(
                entity.getId() != null
                        ? new UsuarioId(entity.getId())
                        : null,
                new Nombre(entity.getNombre()),
                new Correo(entity.getCorreo())
        );
    }
}