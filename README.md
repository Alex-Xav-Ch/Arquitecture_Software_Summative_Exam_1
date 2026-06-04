# Sistema de Biblioteca - Spring Boot (Arquitectura Espagueti - Web)

## 1. Descripción del proyecto

Este proyecto es un sistema de gestión de biblioteca desarrollado en Java con Spring Boot. Permite administrar libros, usuarios y préstamos.

El objetivo principal es implementar una arquitectura tipo código espagueti, donde la lógica de negocio, acceso a datos y control HTTP se encuentran centralizados en un único controlador. Esto permite su comparación posterior con arquitecturas más estructuradas como monolito por capas y DDD.

---

## 2. Tecnologías utilizadas

- Java 21+
- Spring Boot
- Spring Web (API REST)
- Jakarta Persistence API (JPA) con EntityManager
- Base de datos H2
- Swagger
- Maven

---

## 3. Modelo del dominio

### Libro

Entidad que representa un libro en la biblioteca.

Campos principales:

- id
- isbn
- titulo
- autor
- anioPublicacion
- cantidadDisponible

### Usuario

Entidad que representa un usuario del sistema.

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
- RN-05: No se puede eliminar un libro con préstamos activos.
- RN-06: El ISBN de un libro debe ser único.
- RN-07: El correo electrónico de un usuario debe ser único.

---

## 6. API REST

Base URL:

```bash
http://localhost:8080/biblioteca
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

El proyecto utiliza H2 como base de datos con persistencia en archivos.

### Configuración

- Motor: H2
- Persistencia: archivo
- Consola web habilitada

### Consola H2

```bash
http://localhost:8080/h2-console
```

Credenciales:

- JDBC URL: jdbc:h2:file:./data/biblioteca
- Usuario: sa
- Contraseña: (vacío)

---

## 8. Carga de datos iniciales

Los datos iniciales se cargan automáticamente desde:

src/main/resources/data.sql

Este archivo contiene información precargada de libros, usuarios y datos de prueba para el sistema.

---

## 9. Documentación API (Swagger)

Documentación automática de la API usando Swagger.

Acceso:

```bash
http://localhost:8080/swagger-ui/index.html
```

Permite:

- Visualizar endpoints
- Probar operaciones REST
- Revisar esquemas de entrada y salida

---

## 10. Arquitectura del sistema

Este proyecto utiliza una arquitectura tipo código espagueti.

Características:

- Un único controlador central
- Uso directo de EntityManager dentro del controlador
- Lógica de negocio mezclada con endpoints REST
- Sin separación en capas (controller, service, repository)

---

## 11. Ejecución del proyecto

Compilar el proyecto:

```bash
mvn clean install
```

Compilar y ejecutar:

```bash
mvn spring-boot:run
```

Acceso a la aplicación:

```bash
http://localhost:8080
```
