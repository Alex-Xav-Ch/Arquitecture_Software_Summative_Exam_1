

-- LIBROS

INSERT INTO libros (isbn, titulo, autor, cantidad_disponible, anio_publicacion)
VALUES ('134685991', 'Effective Java', 'Joshua Bloch', 5, 2008);

INSERT INTO libros (isbn, titulo, autor, cantidad_disponible, anio_publicacion)
VALUES ('161729494', 'Spring in Action', 'Craig Walls', 3, 2018);

INSERT INTO libros (isbn, titulo, autor, cantidad_disponible, anio_publicacion)
VALUES ('149207250', 'Designing Data-Intensive Applications', 'Martin Kleppmann', 2, 2017);

INSERT INTO libros (isbn, titulo, autor, cantidad_disponible, anio_publicacion)
VALUES ('013235088', 'Clean Code', 'Robert C. Martin', 4, 2008);

INSERT INTO libros (isbn, titulo, autor, cantidad_disponible, anio_publicacion)
VALUES ('020163361', 'Design Patterns', 'Erich Gamma', 1, 1994);

-- USUARIOS
/*
INSERT INTO usuarios (nombre, correo)
VALUES ('Juan Perez', 'juan@correo.com');

INSERT INTO usuarios (nombre, correo)
VALUES ('Maria Lopez', 'maria@correo.com');

INSERT INTO usuarios (nombre, correo)
VALUES ('Carlos Andrade', 'carlos@correo.com');

INSERT INTO usuarios (nombre, correo)
VALUES ('Ana Torres', 'ana@correo.com');

INSERT INTO usuarios (nombre, correo)
VALUES ('Luis Gomez', 'luis@correo.com');

-- PRESTAMOS

INSERT INTO prestamos (
    usuario_id,
    libro_id,
    fecha_prestamo,
    fecha_devolucion,
    estado
)
VALUES (
    1,
    1,
    CURRENT_DATE,
    DATEADD('DAY', 7, CURRENT_DATE),
    'ACTIVO'
);

INSERT INTO prestamos (
    usuario_id,
    libro_id,
    fecha_prestamo,
    fecha_devolucion,
    estado
)
VALUES (
    2,
    2,
    CURRENT_DATE,
    DATEADD('DAY', 7, CURRENT_DATE),
    'ACTIVO'
);

INSERT INTO prestamos (
    usuario_id,
    libro_id,
    fecha_prestamo,
    fecha_devolucion,
    estado
)
VALUES (
    3,
    3,
    CURRENT_DATE,
    DATEADD('DAY', 7, CURRENT_DATE),
    'DEVUELTO'
); */