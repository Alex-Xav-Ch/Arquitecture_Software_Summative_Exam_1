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

# 10. Diseño Estratégico

## Dominio Principal

### Gestión de Biblioteca

**Propósito:**

Administrar libros, usuarios y préstamos dentro de una biblioteca mediante la aplicación de reglas de negocio relacionadas con disponibilidad, préstamos y devoluciones.

---

## Subdominios

| Subdominio           | Tipo       |
| -------------------- | ---------- |
| Catálogo de Libros   | Supporting |
| Gestión de Usuarios  | Supporting |
| Gestión de Préstamos | Core       |

---

### Catálogo de Libros

**Responsable de:**

- Registrar libros
- Consultar libros
- Actualizar libros
- Eliminar libros
- Controlar disponibilidad

---

### Gestión de Usuarios

**Responsable de:**

- Registrar usuarios
- Consultar usuarios

---

### Gestión de Préstamos

Subdominio principal donde se concentran las reglas más importantes del negocio.

**Responsable de:**

- Registrar préstamos
- Registrar devoluciones
- Validar reglas de negocio
- Controlar préstamos activos

---

## Bounded Contexts

# 10. Diseño Estratégico

## Dominio Principal

### Gestión de Biblioteca

**Propósito:**

Administrar libros, usuarios y préstamos dentro de una biblioteca mediante la aplicación de reglas de negocio relacionadas con disponibilidad, préstamos y devoluciones.

---

## Subdominios

| Subdominio           | Tipo       |
| -------------------- | ---------- |
| Catálogo de Libros   | Supporting |
| Gestión de Usuarios  | Supporting |
| Gestión de Préstamos | Core       |

---

### Catálogo de Libros

**Responsable de:**

- Registrar libros
- Consultar libros
- Actualizar libros
- Eliminar libros
- Controlar disponibilidad

---

### Gestión de Usuarios

**Responsable de:**

- Registrar usuarios
- Consultar usuarios

---

### Gestión de Préstamos

Subdominio principal donde se concentran las reglas más importantes del negocio.

**Responsable de:**

- Registrar préstamos
- Registrar devoluciones
- Validar reglas de negocio
- Controlar préstamos activos

---

## Bounded Contexts

### CatalogContext

Responsable de la gestión de libros.

**Casos de uso:**

- RegistrarLibroUseCase
- ConsultarLibrosUseCase
- ActualizarLibroUseCase
- EliminarLibroUseCase
  **Casos de uso:**

* RegistrarLibroUseCase
* ConsultarLibrosUseCase
* ActualizarLibroUseCase
* EliminarLibroUseCase

---

### UserContext

Responsable de la gestión de usuarios.

**Casos de uso:**
**Casos de uso:**

- RegistrarUsuarioUseCase
- ConsultarUsuariosUseCase

---

### LoanContext

Responsable de la gestión de préstamos.

**Casos de uso:**

- RegistrarPrestamoUseCase
- RegistrarDevolucionUseCase
  **Casos de uso:**

* RegistrarPrestamoUseCase
* RegistrarDevolucionUseCase

---

## Context Map

### Patrón utilizado: Partnership

Todos los Bounded Contexts forman parte del mismo sistema y son desarrollados por el mismo equipo.

**Características:**

- Evolucionan juntos.
- Comparten reglas de negocio.
- No existen equipos independientes.
- Mantienen dependencias controladas mediante puertos y adaptadores.

```text
CatalogContext
       ▲
       │
       │
       ▼
LoanContext
       ▲
       │
       ▼
UserContext
```

El contexto de préstamos consume información proveniente de libros y usuarios para ejecutar sus reglas de negocio.

---

## Lenguaje Ubicuo

| Término         | Significado                        |
| --------------- | ---------------------------------- |
| Libro           | Recurso bibliográfico disponible   |
| Usuario         | Persona registrada                 |
| Préstamo        | Entrega temporal de un libro       |
| Devolución      | Retorno de un libro prestado       |
| Disponibilidad  | Cantidad de ejemplares disponibles |
| ISBN            | Identificador único del libro      |
| Préstamo Activo | Préstamo pendiente de devolución   |

---

## Experto del Dominio

### Bibliotecario

Responsable de ejecutar los procesos de:

- Registro de libros
- Registro de usuarios
- Registro de préstamos
- Registro de devoluciones

---

# 11. Diseño Táctico DDD

## CatalogContext

### Aggregate Root

- Libro

### Entity

- Libro

### Value Objects

- LibroId
- ISBN
- AnioPublicacion
- CantidadDisponible

### Invariantes

- ISBN único.
- Cantidad disponible mayor o igual a cero.

### Repositorio

- LibroRepository

### Excepciones

- LibroNoEncontradoException
- ISBNDuplicadoException

### Eventos de Dominio (Diseño)

- LibroRegistrado
- LibroActualizado
- LibroEliminado

---

## UserContext

### Aggregate Root

- Usuario

### Entity

- Usuario

### Value Objects

- UsuarioId
- Nombre
- Correo

### Invariantes

- Correo único.
- Nombre obligatorio.

### Repositorio

- UsuarioRepository

### Excepciones

- UsuarioNoEncontradoException
- CorreoDuplicadoException

### Eventos de Dominio (Diseño)

- UsuarioRegistrado

---

## LoanContext

### Aggregate Root

- Prestamo

### Entity

- Prestamo

### Atributos principales

- PrestamoId id
- UsuarioId usuarioId
- LibroId libroId
- FechaPrestamo fechaPrestamo
- FechaDevolucion fechaDevolucion
- EstadoPrestamo estado

### Value Objects

- PrestamoId
- LibroId
- UsuarioId
- FechaPrestamo
- FechaDevolucion

### Enum

#### EstadoPrestamo

- ACTIVO
- DEVUELTO

### Invariantes

- El libro debe tener disponibilidad.
- Máximo tres préstamos activos por usuario.
- Un préstamo no puede devolverse dos veces.

### Domain Service

#### PrestamoDomainService

**Responsabilidades:**

- Validar límite de préstamos activos.
- Coordinar reglas que involucran múltiples agregados.

### Factory

#### PrestamoFactory

**Responsabilidades:**

- Crear préstamos válidos.
- Inicializar estado ACTIVO.
- Inicializar fecha de préstamo.

### Repositorio

- PrestamoRepository

### Excepciones

- LibroNoDisponibleException
- LimitePrestamosExcedidoException
- PrestamoNoEncontradoException

### Eventos de Dominio (Diseño)

- PrestamoRegistrado
- PrestamoDevuelto

---

# 12. Arquitectura Hexagonal

## Flujo General

## Context Map

### Patrón utilizado: Partnership

Todos los Bounded Contexts forman parte del mismo sistema y son desarrollados por el mismo equipo.

**Características:**

- Evolucionan juntos.
- Comparten reglas de negocio.
- No existen equipos independientes.
- Mantienen dependencias controladas mediante puertos y adaptadores.

```text
CatalogContext
       ▲
       │
       │
       ▼
LoanContext
       ▲
       │
       ▼
UserContext
```

El contexto de préstamos consume información proveniente de libros y usuarios para ejecutar sus reglas de negocio.

---

## Lenguaje Ubicuo

| Término         | Significado                        |
| --------------- | ---------------------------------- |
| Libro           | Recurso bibliográfico disponible   |
| Usuario         | Persona registrada                 |
| Préstamo        | Entrega temporal de un libro       |
| Devolución      | Retorno de un libro prestado       |
| Disponibilidad  | Cantidad de ejemplares disponibles |
| ISBN            | Identificador único del libro      |
| Préstamo Activo | Préstamo pendiente de devolución   |

---

## Experto del Dominio

### Bibliotecario

Responsable de ejecutar los procesos de:

- Registro de libros
- Registro de usuarios
- Registro de préstamos
- Registro de devoluciones

---

# 11. Diseño Táctico DDD

## CatalogContext

### Aggregate Root

- Libro

### Entity

- Libro

### Value Objects

- LibroId
- ISBN
- AnioPublicacion
- CantidadDisponible

### Invariantes

- ISBN único.
- Cantidad disponible mayor o igual a cero.

### Repositorio

- LibroRepository

### Excepciones

- LibroNoEncontradoException
- ISBNDuplicadoException

### Eventos de Dominio (Diseño)

- LibroRegistrado
- LibroActualizado
- LibroEliminado

---

## UserContext

### Aggregate Root

- Usuario

### Entity

- Usuario

### Value Objects

- UsuarioId
- Nombre
- Correo

### Invariantes

- Correo único.
- Nombre obligatorio.

### Repositorio

- UsuarioRepository

### Excepciones

- UsuarioNoEncontradoException
- CorreoDuplicadoException

### Eventos de Dominio (Diseño)

- UsuarioRegistrado

---

## LoanContext

### Aggregate Root

- Prestamo

### Entity

- Prestamo

### Atributos principales

- PrestamoId id
- UsuarioId usuarioId
- LibroId libroId
- FechaPrestamo fechaPrestamo
- FechaDevolucion fechaDevolucion
- EstadoPrestamo estado

### Value Objects

- PrestamoId
- LibroId
- UsuarioId
- FechaPrestamo
- FechaDevolucion

### Enum

#### EstadoPrestamo

- ACTIVO
- DEVUELTO

### Invariantes

- El libro debe tener disponibilidad.
- Máximo tres préstamos activos por usuario.
- Un préstamo no puede devolverse dos veces.

### Domain Service

#### PrestamoDomainService

**Responsabilidades:**

- Validar límite de préstamos activos.
- Coordinar reglas que involucran múltiples agregados.

### Factory

#### PrestamoFactory

**Responsabilidades:**

- Crear préstamos válidos.
- Inicializar estado ACTIVO.
- Inicializar fecha de préstamo.

### Repositorio

- PrestamoRepository

### Excepciones

- LibroNoDisponibleException
- LimitePrestamosExcedidoException
- PrestamoNoEncontradoException

### Eventos de Dominio (Diseño)

- PrestamoRegistrado
- PrestamoDevuelto

---

# 12. Arquitectura Hexagonal

## Flujo General

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

## Componentes

## Componentes

### Domain

### Domain

Contiene las reglas de negocio y el modelo del dominio.

**Ejemplos:**

- Libro
- Usuario
- Prestamo
- Value Objects
- Domain Services
- Excepciones de negocio
  **Ejemplos:**

* Libro
* Usuario
* Prestamo
* Value Objects
* Domain Services
* Excepciones de negocio

---

### Application

---

### Application

Contiene los casos de uso del sistema.

**Ejemplos:**

- RegistrarLibroService
- ConsultarLibrosService
- ActualizarLibroService
- EliminarLibroService
- RegistrarUsuarioService
- ConsultarUsuariosService
- RegistrarPrestamoService
- RegistrarDevolucionService
  **Ejemplos:**

* RegistrarLibroService
* ConsultarLibrosService
* ActualizarLibroService
* EliminarLibroService
* RegistrarUsuarioService
* ConsultarUsuariosService
* RegistrarPrestamoService
* RegistrarDevolucionService

---

### Ports

---

### Ports

Definen contratos de comunicación.

**Ejemplos:**

- LibroRepository
- UsuarioRepository
- PrestamoRepository
- CatalogPort
- UserPort
  **Ejemplos:**

* LibroRepository
* UsuarioRepository
* PrestamoRepository
* CatalogPort
* UserPort

---

### Adapters

---

### Adapters

Implementan los puertos y conectan con tecnologías externas.

**Ejemplos:**

- LibroRepositoryAdapter
- UsuarioRepositoryAdapter
- PrestamoRepositoryAdapter
- CatalogAdapter
- UserAdapter
  **Ejemplos:**

* LibroRepositoryAdapter
* UsuarioRepositoryAdapter
* PrestamoRepositoryAdapter
* CatalogAdapter
* UserAdapter

---

### Infrastructure

---

### Infrastructure

Contiene componentes técnicos.

**Ejemplos:**

- Controllers REST
- Repositorios JPA
- Entidades JPA
- Mappers
- Configuración Spring
  **Ejemplos:**

* Controllers REST
* Repositorios JPA
* Entidades JPA
* Mappers
* Configuración Spring

---

# 13. Estructura del Proyecto

# 13. Estructura del Proyecto

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
    └── DddApplication
    └── DddApplication
```

---

# 14. Beneficios de DDD y Arquitectura Hexagonal

# 14. Beneficios de DDD y Arquitectura Hexagonal

- Mayor separación de responsabilidades.
- Dominio independiente de frameworks.
- Código más mantenible y testeable.
- Menor acoplamiento entre contextos.
- Facilidad para evolucionar el sistema.
- Reutilización de reglas de negocio.
- Preparación para una futura migración a microservicios.

---

# 15. Ejecución del Proyecto

# 15. Ejecución del Proyecto

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
