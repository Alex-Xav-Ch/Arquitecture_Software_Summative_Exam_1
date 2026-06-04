# Sistema de Biblioteca - Spring Boot (Arquitectura Monolítica por Capas)

## 1. Descripción del proyecto

Este proyecto es un sistema de gestión de biblioteca desarrollado en Java con Spring Boot. Permite administrar libros, usuarios y préstamos mediante una API REST.

El objetivo principal es implementar una arquitectura monolítica por capas (Layered Monolith), separando las responsabilidades de presentación, lógica de negocio y acceso a datos.

---

## 2. Tecnologías utilizadas

- Java 21+
- Spring Boot
- Spring Web (API REST)
- Spring Data JPA
- Base de datos H2
- Swagger
- Maven

---

## 3. Modelo del dominio

### Libro

Entidad que representa un libro disponible en la biblioteca.

Campos principales:

- id
- isbn
- titulo
- autor
- anioPublicacion
- cantidadDisponible

### Usuario

Entidad que representa un usuario registrado en el sistema.

Campos principales:

- id
- nombre
- correo

### Prestamo

Entidad que representa el préstamo de un libro a un usuario.

Campos principales:

- id
- usuarioId
- libroId
- fechaPrestamo
- fechaDevolucion
- estado (ACTIVO / DEVUELTO)

---

## 4. Casos de uso

### Gestión de libros

- CU-01: Registrar libro
- CU-02: Consultar libros
- CU-03: Actualizar libro
- CU-04: Eliminar libro

### Gestión de usuarios

- CU-05: Registrar usuario
- CU-06: Consultar usuarios

### Gestión de préstamos

- CU-07: Registrar préstamo
- CU-08: Registrar devolución

---

## 5. Reglas de negocio

- RN-01: Un libro solo puede prestarse si tiene ejemplares disponibles.
- RN-02: Al realizar un préstamo, la cantidad disponible disminuye en una unidad.
- RN-03: Al registrar una devolución, la cantidad disponible aumenta en una unidad.
- RN-04: Un usuario no puede tener más de tres préstamos activos.
- RN-05: No se puede eliminar un libro que tenga préstamos activos.
- RN-06: El ISBN de un libro debe ser único.
- RN-07: El correo electrónico de un usuario debe ser único.

---

## 6. API REST

Base URL:

```bash
http://localhost:8080
```

### Libros

- POST /libros → Registrar libro
- GET /libros → Consultar libros
- PUT /libros/{id} → Actualizar libro
- DELETE /libros/{id} → Eliminar libro

### Usuarios

- POST /usuarios → Registrar usuario
- GET /usuarios → Consultar usuarios

### Préstamos

- POST /prestamos?usuarioId=&libroId= → Registrar préstamo
- PUT /prestamos/{id}/devolver → Registrar devolución
- GET /prestamos/activos → Consultar préstamos activos

---

## 7. Base de datos H2

El proyecto utiliza H2 como base de datos embebida.

### Consola H2

```bash
http://localhost:8080/h2-console
```

Credenciales:

- JDBC URL: jdbc:h2:mem:testdb
- Usuario: sa
- Contraseña: (vacío)

---

## 8. Carga de datos iniciales

Los datos iniciales se cargan automáticamente desde:

```text
src/main/resources/data.sql
```

Este archivo contiene información de prueba para libros, usuarios y préstamos.

---

## 9. Documentación API (Swagger)

Acceso:

```bash
http://localhost:8080/swagger-ui/index.html
```

Permite:

- Consultar endpoints disponibles
- Probar operaciones REST
- Revisar modelos de entrada y salida

---

## 10. Arquitectura del sistema

El proyecto utiliza una arquitectura monolítica por capas.

### Estructura

```text
controller
    ↓
service
    ↓
repository
    ↓
database
```

### Capas implementadas

#### Controller

Responsable de recibir las solicitudes HTTP y devolver respuestas REST.

Ejemplos:

- LibroController
- UsuarioController
- PrestamoController

#### Service

Contiene la lógica de negocio y las reglas del dominio.

Ejemplos:

- LibroService
- UsuarioService
- PrestamoService

#### Repository

Responsable del acceso a datos utilizando Spring Data JPA.

Ejemplos:

- LibroRepository
- UsuarioRepository
- PrestamoRepository

#### Entity

Representa las entidades persistentes del dominio.

Ejemplos:

- Libro
- Usuario
- Prestamo

### Beneficios respecto a la arquitectura espagueti

- Separación de responsabilidades.
- Menor acoplamiento entre componentes.
- Mayor mantenibilidad.
- Código más reutilizable.
- Mejor organización para escalar el sistema.

---

## 11. Estructura del proyecto

```text
src/main/java
└── com.biblioteca
    ├── controller
    │   ├── LibroController
    │   ├── UsuarioController
    │   └── PrestamoController
    │
    ├── service
    │   ├── LibroService
    │   ├── UsuarioService
    │   └── PrestamoService
    │
    ├── repository
    │   ├── LibroRepository
    │   ├── UsuarioRepository
    │   └── PrestamoRepository
    │
    ├── entity
    │   ├── Libro
    │   ├── Usuario
    │   └── Prestamo
    │
    └── BibliotecaApplication
```

---

## 12. Ejecución del proyecto

Compilar el proyecto:

```bash
mvn clean install
```

Ejecutar la aplicación:

```bash
mvn spring-boot:run
```

Acceso:

```bash
http://localhost:8080
```
