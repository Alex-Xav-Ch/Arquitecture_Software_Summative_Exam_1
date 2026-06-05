package com.prueba.sumativa.ddd.loan.application.port.out;

public interface CatalogPort {
    boolean libroDisponible(Long libroId);
    void disminuirDisponibilidad(Long libroId);
    void aumentarDisponibilidad(Long libroId);
}
