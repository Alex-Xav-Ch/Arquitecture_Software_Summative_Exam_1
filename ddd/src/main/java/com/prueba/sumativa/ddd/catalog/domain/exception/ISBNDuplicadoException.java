package com.prueba.sumativa.ddd.catalog.domain.exception;

public class ISBNDuplicadoException extends RuntimeException {
    
    public ISBNDuplicadoException(String isbn) {
        super("Ya existe un libro registrado con ISBN: " + isbn);
    }
}
