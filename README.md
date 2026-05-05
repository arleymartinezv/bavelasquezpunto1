# bavelasquezpunto1 — Gestión de Usuarios

**Taller Spring Boot Básico — Punto 1**  
**Programación por Componentes**  
**Universidad Distrital Francisco José de Caldas**  
**Estudiante:** Brayan Arley Velásquez Martínez — 20172578001  
**Docente:** Noé Arcos Muñoz

---

## Descripción

API REST desarrollada con **Spring Boot** que permite registrar, listar y eliminar usuarios. Cada usuario tiene nombre, correo y edad. La persistencia es en memoria (lista estática) mientras la aplicación está en ejecución.

---

## Tecnologías

| Tecnología | Versión |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.5 |
| Spring Web | (incluido en Boot) |
| SpringDoc OpenAPI (Swagger) | 2.8.5 |
| Maven | Wrapper incluido |

---

## Arquitectura MVC

```
com.Velasquez1.BavmUsuarios
├── model/
│   └── User.java              ← Clase modelo (id, nombre, correo, edad)
├── service/
│   └── UsuarioService.java    ← Lógica de negocio (@Service)
├── controller/
│   └── UsuarioController.java ← Endpoints REST (@RestController)
└── BavmUsuariosApplication.java
```

---

## Diagrama de Clases

El diagrama en formato draw.io se encuentra en:
```
diagrama/DiagramaClases_BavmUsuarios.drawio
```

---

## Cómo ejecutar

**Desde Eclipse:**
1. `File → Import → Maven → Existing Maven Projects`
2. Clic derecho sobre el proyecto → `Run As → Spring Boot App`
3. La aplicación inicia en `http://localhost:8080`

**Desde terminal:**
```bash
./mvnw spring-boot:run
```

---

## Documentación Swagger UI

Con la aplicación corriendo, accede a:

```
http://localhost:8080/swagger-ui/index.html
```

Allí puedes visualizar y probar todos los endpoints de forma interactiva.

---

## Endpoints

### `GET /usuarios`
Lista todos los usuarios registrados.

- **Parámetros:** ninguno
- **Respuesta exitosa `200`:**
```json
[
  {
    "id": 1,
    "nombre": "Arley Velásquez",
    "correo": "bavelasquezm@udistrital.edu.co",
    "edad": 25
  }
]
```
- **Respuesta vacía:** `[]`

---

### `POST /usuarios`
Registra un nuevo usuario en el sistema.

- **Parámetros:** cuerpo JSON con los datos del usuario
- **Body (JSON):**
```json
{
  "nombre": "Arley Velásquez",
  "correo": "bavelasquezm@udistrital.edu.co",
  "edad": 25
}
```
- **Respuesta exitosa `200`:**
```json
{
  "id": 1,
  "nombre": "Arley Velásquez",
  "correo": "bavelasquezm@udistrital.edu.co",
  "edad": 25
}
```
> El campo `id` es asignado automáticamente por el sistema.

---

### `DELETE /usuarios/{id}`
Elimina un usuario según su `id`.

- **Parámetro de ruta:** `id` (Long) — identificador del usuario
- **Ejemplo:** `DELETE /usuarios/1`
- **Respuesta exitosa `200`:**
```
Usuario eliminado correctamente.
```
- **Respuesta si no existe `200`:**
```
Usuario no encontrado.
```

---

## Pruebas con Postman

| Operación | Método | URL |
|---|---|---|
| Listar usuarios | `GET` | `http://localhost:8080/usuarios` |
| Registrar usuario | `POST` | `http://localhost:8080/usuarios` |
| Eliminar usuario | `DELETE` | `http://localhost:8080/usuarios/1` |

Para el `POST`, en Postman seleccionar:  
`Body → raw → JSON` y pegar el cuerpo indicado arriba.

---

## Flujo de datos

```
Cliente (Postman / Browser)
        │
        ▼
UsuarioController  (@RestController, /usuarios)
        │
        ▼
UsuarioService     (@Service)
        │
        ▼
List<User>         (persistencia en memoria)
```
