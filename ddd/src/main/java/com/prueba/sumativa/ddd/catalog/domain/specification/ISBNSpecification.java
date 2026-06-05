package com.prueba.sumativa.ddd.catalog.domain.specification;

import com.prueba.sumativa.ddd.catalog.domain.valueObject.ISBN;

public interface ISBNSpecification {
    boolean esUnico(ISBN isbn);
}
