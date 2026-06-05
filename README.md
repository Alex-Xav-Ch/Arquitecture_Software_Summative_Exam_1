# Sistema de Gestión de Biblioteca

## Comparación de Arquitecturas de Software

## 1. Introducción

El presente proyecto tiene como finalidad desarrollar un Sistema de Gestión de Biblioteca Básico utilizando tres enfoques arquitectónicos diferentes, con el objetivo de analizar cómo la arquitectura influye en la organización, mantenibilidad, escalabilidad y calidad del software.

El sistema permite administrar libros, usuarios y préstamos dentro de una biblioteca, manteniendo las mismas funcionalidades y reglas de negocio en cada implementación.

---

## 2. Objetivos

### Objetivo general

Implementar un sistema de gestión de biblioteca utilizando distintos enfoques arquitectónicos para comparar sus características, ventajas y limitaciones.

### Objetivos específicos

* Analizar los problemas asociados al código espagueti.
* Implementar una arquitectura monolítica por capas.
* Aplicar principios de Domain-Driven Design (DDD).
* Comparar la organización y mantenibilidad de cada solución.
* Utilizar control de versiones para gestionar cada arquitectura de forma independiente.

---

## 3. Tema del proyecto

### Sistema de Gestión de Biblioteca

El sistema tiene como propósito administrar los recursos bibliográficos de una biblioteca y controlar los préstamos realizados a los usuarios registrados.

Las funcionalidades implementadas incluyen:

* Gestión de libros.
* Gestión de usuarios.
* Gestión de préstamos.
* Gestión de devoluciones.

---

## 4. Stack tecnológico

### Lenguaje

* Java 21 (LTS)

### Frameworks y tecnologías

* Spring Boot
* Spring Data JPA
* H2 Database
* Swagger / OpenAPI
* Maven

---

## 5. Definición del dominio

El dominio del sistema corresponde a la gestión de una biblioteca donde se administran libros, usuarios y préstamos.

### Libro

Representa un recurso bibliográfico disponible en la biblioteca.

#### Atributos

* Id
* ISBN
* Título
* Autor
* Año de publicación
* Cantidad disponible

---

### Usuario

Representa una persona registrada en la biblioteca.

#### Atributos

* Id
* Nombre
* Correo electrónico

---

### Préstamo

Representa la asignación temporal de un libro a un usuario.

#### Atributos

* Id
* Usuario
* Libro
* Fecha de préstamo
* Fecha estimada de devolución
* Estado del préstamo

---

## 6. Casos de uso

### Gestión de libros

| Código | Caso de uso      |
| ------ | ---------------- |
| CU-01  | Registrar libro  |
| CU-02  | Consultar libros |
| CU-03  | Actualizar libro |
| CU-04  | Eliminar libro   |

### Gestión de usuarios

| Código | Caso de uso        |
| ------ | ------------------ |
| CU-05  | Registrar usuario  |
| CU-06  | Consultar usuarios |

### Gestión de préstamos

| Código | Caso de uso          |
| ------ | -------------------- |
| CU-07  | Registrar préstamo   |
| CU-08  | Registrar devolución |

---

## 7. Reglas de negocio

| Código | Regla                                                                     |
| ------ | ------------------------------------------------------------------------- |
| RN-01  | Un libro solo puede prestarse si tiene ejemplares disponibles             |
| RN-02  | Al realizar un préstamo, la cantidad disponible disminuye en una unidad   |
| RN-03  | Al registrar una devolución, la cantidad disponible aumenta en una unidad |
| RN-04  | Un usuario no puede tener más de tres préstamos activos                   |
| RN-05  | No se puede eliminar un libro que tenga préstamos activos                 |
| RN-06  | El ISBN de un libro debe ser único                                        |
| RN-07  | El correo electrónico de un usuario debe ser único                        |

---

## 8. Arquitecturas implementadas

El mismo sistema fue desarrollado utilizando tres enfoques arquitectónicos diferentes.

### 8.1 Código Espagueti

Implementación sin separación formal de responsabilidades.

#### Características

* Lógica de negocio mezclada con acceso a datos.
* Alto acoplamiento.
* Escasa organización del código.
* Difícil mantenimiento y evolución.

#### Objetivo

Evidenciar los problemas que aparecen cuando un sistema crece sin una arquitectura definida.

---

### 8.2 Monolito por Capas

Implementación basada en la separación tradicional por capas.

#### Capas

* Presentación (Controllers)
* Servicios
* Repositorios
* Entidades

#### Beneficios

* Mejor organización.
* Menor acoplamiento que el código espagueti.
* Fácil comprensión para proyectos pequeños y medianos.

---

### 8.3 Domain-Driven Design (DDD)

Implementación basada en el diseño orientado al dominio.

#### Aplicaciones realizadas

* DDD Estratégico
* DDD Táctico
* Arquitectura Hexagonal

#### Componentes principales

* Bounded Contexts
* Aggregates
* Value Objects
* Domain Services
* Use Cases
* Ports
* Adapters

#### Beneficios

* Dominio como núcleo del sistema.
* Mayor mantenibilidad.
* Menor dependencia tecnológica.
* Mayor escalabilidad.

---

## 9. Comparación de arquitecturas

| Característica                  | Código Espagueti | Monolito por Capas | DDD      |
| ------------------------------- | ---------------- | ------------------ | -------- |
| Separación de responsabilidades | Baja             | Media              | Alta     |
| Acoplamiento                    | Alto             | Medio              | Bajo     |
| Escalabilidad                   | Baja             | Media              | Alta     |
| Mantenibilidad                  | Baja             | Media              | Alta     |
| Reutilización                   | Baja             | Media              | Alta     |
| Complejidad inicial             | Baja             | Media              | Alta     |
| Evolución del sistema           | Difícil          | Moderada           | Sencilla |

---

## 10. Control de versiones

Se utilizó Git para el control de versiones y GitHub para el almacenamiento del repositorio.

### Estructura de ramas

```text
main
│
├── spaghetti-web
│   └── Implementación con código espagueti
│
├── layered-monolith
│   └── Implementación con arquitectura monolítica por capas
│
└── ddd
    └── Implementación basada en Domain-Driven Design
```

### Descripción de ramas

#### main

Contiene la documentación general del proyecto.

#### spaghetti-web

Contiene la implementación utilizando código espagueti.

#### layered-monolith

Contiene la implementación utilizando arquitectura monolítica por capas.

#### ddd

Contiene la implementación utilizando DDD y Arquitectura Hexagonal.

---

## 11. Estructura general del repositorio

```text
biblioteca
│
├── README.md
│
├── spaghetti-web
│
├── layered-monolith
│
└── ddd
```

---

## 12. Conclusiones

La implementación del mismo sistema utilizando distintos enfoques arquitectónicos permitió observar cómo la arquitectura impacta directamente en la calidad del software.

El código espagueti ofrece rapidez inicial pero presenta dificultades de mantenimiento. La arquitectura monolítica por capas mejora significativamente la organización del sistema. Finalmente, la implementación basada en DDD proporciona una mejor representación del dominio del negocio, mayor desacoplamiento y una estructura más preparada para evolucionar ante nuevos requerimientos.
