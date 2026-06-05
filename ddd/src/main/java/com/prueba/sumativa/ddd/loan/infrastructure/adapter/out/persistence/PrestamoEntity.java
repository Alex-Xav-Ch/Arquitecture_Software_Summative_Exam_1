package com.prueba.sumativa.ddd.loan.infrastructure.adapter.out.persistence;

import jakarta.persistence.*;

import java.time.LocalDate;

import com.prueba.sumativa.ddd.loan.domain.valueObject.EstadoPrestamo;
@Entity
@Table(name = "prestamos")
public class PrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long libroId;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private LocalDate fechaPrestamo;

    @Column(nullable = true)
    private LocalDate fechaDevolucion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPrestamo estado;

    protected PrestamoEntity() {
    }

    public PrestamoEntity(
            Long id,
            Long libroId,
            Long usuarioId,
            LocalDate fechaPrestamo,
            LocalDate fechaDevolucion,
            EstadoPrestamo estado) {

        this.id = id;
        this.libroId = libroId;
        this.usuarioId = usuarioId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Long getLibroId() {
        return libroId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }
}
