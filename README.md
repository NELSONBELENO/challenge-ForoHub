# Foro Hub API

## 📝 Descripción General

**Foro Hub API** es un sistema backend robusto desarrollado en **Spring Boot** que implementa una API RESTful para gestionar un foro académico. La plataforma permite la autenticación de usuarios, la administración de cursos y la creación y discusión de tópicos (temas) relacionados.

Este proyecto replica el funcionamiento interno del foro de Alura, facilitando el aprendizaje colaborativo entre estudiantes, profesores y moderadores.

---

## 🚀 Funcionalidades Principales

- Autenticación de usuarios mediante **JWT**
- CRUD de **Tópicos**
- CRUD de **Cursos**
- Registro de nuevos usuarios
- Control de acceso basado en roles (`ADMIN`, `MODERADOR`, `ESTUDIANTE`)
- Manejo centralizado de errores

---

## 📌 Endpoints

### 🔐 Autenticación

#### Iniciar Sesión
- **POST** `/login`
- **Descripción:** Autentica al usuario y devuelve un token JWT.
- **Body:**
  ```json
  {
    "login": "user@example.com",
    "clave": "password"
  }
  ```
- **Respuesta:**
  ```json
  {
    "jwtToken": "<token>"
  }
  ```

#### Registro de Usuario
- **POST** `/registro`
- **Descripción:** Registra un nuevo usuario.
- **Body:**
  ```json
  {
    "nombre": "John Doe",
    "email": "john@example.com",
    "clave": "password",
    "rol": "ESTUDIANTE"
  }
  ```
- **Respuesta:**
  ```json
  {
    "id": 1,
    "nombre": "John Doe",
    "email": "john@example.com",
    "rol": "ESTUDIANTE"
  }
  ```

---

### 📚 Gestión de Cursos

#### Crear Curso
- **POST** `/cursos`
- **Body:**
  ```json
  {
    "nombre": "Nombre del Curso",
    "categoria": "Categoría"
  }
  ```

#### Listar Cursos
- **GET** `/cursos`

#### Obtener Curso por ID
- **GET** `/cursos/{id}`

#### Actualizar Curso
- **PUT** `/cursos/{id}`
- **Body:**
  ```json
  {
    "nombre": "Curso Actualizado",
    "categoria": "Categoría Actualizada"
  }
  ```

#### Eliminar Curso
- **DELETE** `/cursos/{id}`

---

### 💬 Gestión de Tópicos

#### Crear Tópico
- **POST** `/topicos`
- **Body:**
  ```json
  {
    "titulo": "Título del Tópico",
    "mensaje": "Contenido del mensaje",
    "autorId": 1,
    "cursoId": 1
  }
  ```

#### Listar Tópicos
- **GET** `/topicos`

#### Obtener Tópico por ID
- **GET** `/topicos/{id}`

#### Actualizar Tópico
- **PUT** `/topicos/{id}`
- **Body:**
  ```json
  {
    "titulo": "Título Actualizado",
    "mensaje": "Mensaje Actualizado",
    "status": "SOLUCIONADO"
  }
  ```

#### Eliminar Tópico
- **DELETE** `/topicos/{id}`

---

## 🔐 Seguridad

- Autenticación basada en JWT.
- Acceso restringido por roles:
  - `/topicos` y `/cursos`:
    - `GET`: Requiere autenticación.
    - `POST`, `PUT`, `DELETE`: Requiere rol `ADMIN` o `MODERADOR`.

---

## ⚠️ Manejo de Errores

- `400 Bad Request` – Error de validación.
- `401 Unauthorized` – Token inválido o faltante.
- `404 Not Found` – Recurso no encontrado.
- `500 Internal Server Error` – Error inesperado del servidor.

---

## 📦 Estructura del Proyecto

### DTOs

| DTO | Descripción |
|-----|-------------|
| `DatosRegistroUsuario` | Registro de usuarios |
| `DatosRespuestaRegistro` | Respuesta al registro |
| `DatosRegistroCurso` | Crear curso |
| `DatosActualizarCurso` | Actualizar curso |
| `DatosRespuestaCurso` | Respuesta de curso |
| `DatosRegistroTopico` | Crear tópico |
| `DatosActualizarTopico` | Actualizar tópico |
| `DatosRespuestaTopico` | Respuesta de tópico |

### Modelos

| Entidad | Descripción |
|--------|-------------|
| `Usuario` | Representa un usuario del sistema |
| `Curso` | Representa un curso |
| `Topico` | Representa un tópico de discusión |

### Repositorios

| Repositorio | Propósito |
|-------------|-----------|
| `UsuarioRepository` | Persistencia de usuarios |
| `CursoRepository` | Persistencia de cursos |
| `TopicoRepository` | Persistencia de tópicos |

### Servicios

| Servicio | Funcionalidad |
|----------|----------------|
| `UsuarioService` | Lógica de negocio para usuarios |
| `CursoService` | Lógica de negocio para cursos |
| `TopicoService` | Lógica de negocio para tópicos |
| `TokenService` | Generación y validación de JWT |

### Middleware

| Componente | Descripción |
|------------|-------------|
| `SecurityFilter` | Filtro para validar tokens JWT |
| `TratadorDeErrores` | Manejo centralizado de errores |

---

## 🛠️ Primeros Pasos

1. Clona el repositorio:
   ```bash
   git clone <url-del-repositorio>
   cd foro-hub-api
   ```

2. Configura la base de datos en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
   spring.datasource.username=usuario
   spring.datasource.password=contraseña
   ```

3. Define la clave secreta JWT:
   ```properties
   foro.jwt.secret=clave_super_secreta
   ```

4. Ejecuta la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 🎯 Contexto del Proyecto

Este proyecto forma parte del **Challenge Back End de Alura**, en el cual replicamos el funcionamiento de un foro académico a nivel backend. El desarrollo se basa en prácticas ágiles, con tareas organizadas en un tablero Trello y entregas semanales. La principal meta es construir una API funcional que gestione tópicos, usuarios y cursos, aplicando autenticación y validaciones de negocio.

---

## 📌 Licencia

Este proyecto se encuentra bajo la licencia MIT.