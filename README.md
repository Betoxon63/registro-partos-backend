# 🏥 Registro de Partos - Backend (Spring Boot)

Este repositorio contiene el código fuente para el servicio de backend de la aplicación de Registro de Partos, desarrollado utilizando el framework Spring Boot 3.x, Java 21 y PostgreSQL como base de datos.

## 🚀 Tecnologías Principales

* **Lenguaje:** Java 21 (LTS)
* **Framework:** Spring Boot 3.2.x
* **Gestor de Dependencias:** Maven
* **Base de Datos:** PostgreSQL
* **ORM:** Spring Data JPA (Hibernate)
* **Seguridad:** Spring Security

## ⚙️ Configuración y Ejecución Local

Sigue estos pasos para poner en marcha el servicio en tu entorno local.

### 1. Requisitos Previos

Asegúrate de tener instalado y configurado:
* JDK 21
* Maven
* PostgreSQL Server (corriendo en `localhost:5432`)

### 2. Configuración de la Base de Datos

El proyecto se conecta a una base de datos PostgreSQL.

1.  Crea una base de datos llamada `registro_partos` en tu servidor PostgreSQL.
2.  Edita el archivo de configuración `src/main/resources/application.properties` con tus credenciales:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/registro_partos
    spring.datasource.username=postgres
    spring.datasource.password=Cony1606
    ```

### 3. Configuración de Seguridad y CORS

Para permitir la comunicación con el frontend (que corre en el puerto 4200), se ha configurado **Spring Security** para:
* Permitir el acceso no autenticado a todas las rutas `/api/**`.
* Deshabilitar CSRF (necesario para APIs REST).
* Permitir peticiones CORS desde `http://localhost:4200`.

### 4. Ejecución

Ejecuta la clase principal `RegistroPartosApplication.java` desde tu IDE (IntelliJ IDEA). El servidor iniciará en el puerto **8080**.

---

## 📝 Estado Actual del Desarrollo (Hitos Logrados)

* **Conexión Verificada:** El *endpoint* `/api/test` está funcionando y es accesible desde el frontend.
* **Conexión DB:** Conexión a PostgreSQL `registro_partos` exitosa.
* **Seguridad:** Configuración inicial de Spring Security implementada para permitir el acceso a las APIs.
