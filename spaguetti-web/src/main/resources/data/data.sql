-- LIBROS

INSERT INTO libros (isbn, titulo, autor, cantidad_disponible)
VALUES ('9780134685991', 'Effective Java', 'Joshua Bloch', 5);

INSERT INTO libros (isbn, titulo, autor, cantidad_disponible)
VALUES ('9781617294945', 'Spring in Action', 'Craig Walls', 3);

INSERT INTO libros (isbn, titulo, autor, cantidad_disponible)
VALUES ('9781492072508', 'Designing Data Intensive Applications', 'Martin Kleppmann', 2);

INSERT INTO libros (isbn, titulo, autor, cantidad_disponible)
VALUES ('9780132350884', 'Clean Code', 'Robert C. Martin', 4);

INSERT INTO libros (isbn, titulo, autor, cantidad_disponible)
VALUES ('9780201633610', 'Design Patterns', 'Erich Gamma', 1);

-- USUARIOS

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
);