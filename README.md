# Sistema de Biblioteca - Spring Boot (DDD + Arquitectura Hexagonal)

## 1. Descripción del proyecto

Este proyecto es un sistema de gestión de biblioteca desarrollado en Java con Spring Boot. Permite administrar libros, usuarios y préstamos mediante una API REST.

El objetivo principal es implementar Domain-Driven Design (DDD) junto con Arquitectura Hexagonal (Ports and Adapters), separando claramente el dominio de negocio de las tecnologías de infraestructura y favoreciendo un diseño más mantenible y escalable.

---

## 2. Tecnologías utilizadas

- Java 21+
- Spring Boot
- Spring Web (API REST)
- Spring Data JPA
- Base de datos H2
- Swagger / OpenAPI
- Maven

---

## 3. Modelo del dominio

El sistema está dividido en tres Bounded Contexts:

### CatalogContext

Gestiona la información de los libros disponibles en la biblioteca.

#### Libro

Campos principales:

- id
- isbn
- titulo
- autor
- anioPublicacion
- cantidadDisponible

---

### UserContext

Gestiona los usuarios registrados en la biblioteca.

#### Usuario

Campos principales:

- id
- nombre
- correo

---

### LoanContext

Gestiona los préstamos y devoluciones de libros.

#### Prestamo

Campos principales:

- id
- libroId
- usuarioId
- fechaPrestamo
- estado

Estado:

- ACTIVO
- DEVUELTO

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

### Libros

- RN-01: Un libro solo puede prestarse si tiene ejemplares disponibles.
- RN-02: Al realizar un préstamo, la cantidad disponible disminuye en una unidad.
- RN-03: Al registrar una devolución, la cantidad disponible aumenta en una unidad.
- RN-04: No se puede registrar un libro con ISBN duplicado.

### Usuarios

- RN-05: El correo electrónico de un usuario debe ser único.

### Préstamos

- RN-06: Un usuario no puede tener más de tres préstamos activos simultáneamente.
- RN-07: No puede devolverse un préstamo que ya fue devuelto.

---

## 6. API REST

Base URL:

```bash
http://localhost:8080
```

### Libros

```http
POST   /api/libros
GET    /api/libros
PUT    /api/libros/{id}
DELETE /api/libros/{id}
```

### Usuarios

```http
POST /api/usuarios
GET  /api/usuarios
```

### Préstamos

```http
POST /api/prestamos
POST /api/prestamos/{id}/devolucion
```

---

## 7. Base de datos H2

El proyecto utiliza H2 como base de datos embebida.

### Consola H2

```bash
http://localhost:8080/h2-console
```

Credenciales:

```text
JDBC URL: jdbc:h2:mem:testdb
Usuario : sa
Contraseña : (vacío)
```

---

## 8. Documentación API (Swagger)

Acceso:

```bash
http://localhost:8080/swagger-ui/index.html
```

Permite:

- Consultar endpoints disponibles.
- Probar operaciones REST.
- Revisar contratos de entrada y salida.

---

## 9. Arquitectura del sistema

El proyecto implementa DDD táctico junto con Arquitectura Hexagonal.

### Principios aplicados

- Separación entre dominio e infraestructura.
- Dependencias dirigidas hacia el dominio.
- Casos de uso desacoplados de frameworks.
- Comunicación mediante puertos y adaptadores.
- Contextos delimitados (Bounded Contexts).

---

## 10. Bounded Contexts

### CatalogContext

Responsable de la gestión de libros.

Casos de uso:

- RegistrarLibroUseCase
- ConsultarLibrosUseCase
- ActualizarLibroUseCase
- EliminarLibroUseCase

---

### UserContext

Responsable de la gestión de usuarios.

Casos de uso:

- RegistrarUsuarioUseCase
- ConsultarUsuariosUseCase

---

### LoanContext

Responsable de la gestión de préstamos.

Casos de uso:

- RegistrarPrestamoUseCase
- RegistrarDevolucionUseCase

---

## 11. Arquitectura Hexagonal

### Flujo general

```text
Controller
    ↓
Use Case
    ↓
Domain
    ↓
Port
    ↓
Adapter
    ↓
Database
```

### Componentes

#### Domain

Contiene las reglas de negocio y el modelo del dominio.

Ejemplos:

- Libro
- Usuario
- Prestamo
- Value Objects
- Domain Services
- Excepciones de negocio

#### Application

Contiene los casos de uso del sistema.

Ejemplos:

- RegistrarLibroService
- RegistrarUsuarioService
- RegistrarPrestamoService
- RegistrarDevolucionService

#### Ports

Definen contratos de comunicación.

Ejemplos:

- LibroRepository
- UsuarioRepository
- PrestamoRepository
- CatalogPort
- UserPort

#### Adapters

Implementan los puertos y conectan con tecnologías externas.

Ejemplos:

- LibroRepositoryAdapter
- UsuarioRepositoryAdapter
- PrestamoRepositoryAdapter
- CatalogAdapter
- UserAdapter

#### Infrastructure

Contiene componentes técnicos.

Ejemplos:

- Controllers REST
- Repositorios JPA
- Entidades JPA
- Mappers
- Configuración Spring

---

## 12. Estructura del proyecto

```text
src/main/java
└── com.biblioteca
    ├── catalog
    │   ├── application
    │   ├── domain
    │   └── infrastructure
    │
    ├── user
    │   ├── application
    │   ├── domain
    │   └── infrastructure
    │
    ├── loan
    │   ├── application
    │   ├── domain
    │   └── infrastructure
    │
    └── BibliotecaApplication
```

---

## 13. Beneficios de DDD y Arquitectura Hexagonal

- Mayor separación de responsabilidades.
- Dominio independiente de frameworks.
- Código más mantenible y testeable.
- Menor acoplamiento entre contextos.
- Facilidad para evolucionar el sistema.
- Reutilización de reglas de negocio.
- Preparación para una futura migración a microservicios.

---

## 14. Ejecución del proyecto

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
