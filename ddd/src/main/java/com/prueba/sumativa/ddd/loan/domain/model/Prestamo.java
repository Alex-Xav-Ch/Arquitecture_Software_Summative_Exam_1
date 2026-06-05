package com.prueba.sumativa.ddd.loan.domain.model;

import com.prueba.sumativa.ddd.loan.domain.valueObject.EstadoPrestamo;
import com.prueba.sumativa.ddd.loan.domain.valueObject.FechaDevolucion;
import com.prueba.sumativa.ddd.loan.domain.valueObject.FechaPrestamo;
import com.prueba.sumativa.ddd.loan.domain.valueObject.LibroId;
import com.prueba.sumativa.ddd.loan.domain.valueObject.UsuarioId;

public class Prestamo {

    private PrestamoId id;
    private LibroId libroId;
    private UsuarioId usuarioId;
    private FechaPrestamo fechaPrestamo;
    private FechaDevolucion fechaDevolucion;
    private EstadoPrestamo estado;

    protected Prestamo(
            PrestamoId id,
            LibroId libroId,
            UsuarioId usuarioId,
            FechaPrestamo fechaPrestamo,
            FechaDevolucion fechaDevolucion,
            EstadoPrestamo estado) {

        this.id = id;
        this.libroId = libroId;
        this.usuarioId = usuarioId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public void devolver() {
        if (estado == EstadoPrestamo.DEVUELTO) {
            throw new IllegalStateException("El préstamo ya fue devuelto");
        }

        estado = EstadoPrestamo.DEVUELTO;
    }

    public PrestamoId getId() {
        return id;
    }

    public void setId(PrestamoId id) {
        this.id = id;
    }

    public LibroId getLibroId() {
        return libroId;
    }

    public void setLibroId(LibroId libroId) {
        this.libroId = libroId;
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UsuarioId usuarioId) {
        this.usuarioId = usuarioId;
    }

    public FechaPrestamo getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(FechaPrestamo fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public FechaDevolucion getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(FechaDevolucion fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }
}