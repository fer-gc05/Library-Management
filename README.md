# Sistema de Gestión de Biblioteca

API REST para la gestión de libros, miembros, préstamos y autores de una biblioteca.

## Características

- Gestión de libros con metadatos (título, editorial, idioma, etc.)
- Registro y gestión de miembros
- Sistema de seguimiento de préstamos
- Gestión de autores
- Integración con búsqueda externa de libros

## Estructura del Proyecto
```
library-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── library/
│   │   │           ├── controllers/
|   |   |           |   ├── google.books.api/
|   |   |           |       ├── BookApiRestController.java
│   │   │           │   ├── AuthorsController.java
│   │   │           │   ├── BooksController.java
│   │   │           │   ├── LoansController.java
│   │   │           │   └── MembersController.java
│   │   │           ├── models/
|   |   |           |   ├── google.books.api/
|   |   |           |       ├── BookApi.java
│   │   │           │   ├── Authors.java
│   │   │           │   ├── Books.java
│   │   │           │   ├── Loans.java
│   │   │           │   └── Members.java
│   │   │           ├── repositories/
│   │   │           │   ├── AuthorsRepository.java
│   │   │           │   ├── BooksRepository.java
│   │   │           │   ├── LoansRepository.java
│   │   │           │   └── MembersRepository.java
│   │   │           └── services/
|   |   |               ├── google.books.api/
|   |   |               |   ├──BookApiService
│   │   │               ├── AuthorsService.java
│   │   │               ├── BooksService.java
│   │   │               ├── LoansService.java
│   │   │               └── MembersService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## Dependencias

### Principales
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Mysql
- SpringDoc OpenAPI UI
- Lombok

### Testing
- Spring Boot Starter Test

## Endpoints de la API

### Libros
- GET `/api/v1/books/all` - Listar todos los libros
- GET `/api/v1/books/byId/{id}` - Obtener libro por ID
- GET `/api/v1/books/byTitle/{title}` - Buscar libros por título
- GET `/api/v1/books/search?title={title}` - Búsqueda externa de libros
- POST `/api/v1/books/add` - Agregar nuevo libro
- PUT `/api/v1/books/update` - Actualizar libro
- DELETE `/api/v1/books/delete/{id}` - Eliminar libro

### Miembros
- GET `/api/v1/members/all` - Listar todos los miembros
- GET `/api/v1/members/byId/{id}` - Obtener miembro por ID
- GET `/api/v1/members/byEmail/{email}` - Obtener miembro por email
- POST `/api/v1/members/add` - Registrar nuevo miembro
- PUT `/api/v1/members/update` - Actualizar miembro
- DELETE `/api/v1/members/delete/{id}` - Eliminar miembro

### Préstamos
- GET `/api/v1/loans/all` - Listar todos los préstamos
- GET `/api/v1/loans/byMemberId/{memberId}` - Obtener préstamos por miembro
- GET `/api/v1/loans/byBookId/{bookId}` - Obtener préstamos por libro
- POST `/api/v1/loans/add` - Crear nuevo préstamo
- PUT `/api/v1/loans/update` - Actualizar préstamo
- DELETE `/api/v1/loans/delete/{id}` - Eliminar préstamo

### Autores
- GET `/api/v1/authors/all` - Listar todos los autores
- GET `/api/v1/authors/byId/{id}` - Obtener autor por ID
- POST `/api/v1/authors/add` - Agregar nuevo autor
- PUT `/api/v1/authors/update` - Actualizar autor
- DELETE `/api/v1/authors/delete/{id}` - Eliminar autor

## Modelos de Datos

### Libro
```json
{
  "id": "long",
  "title": "string",
  "publisher": "string",
  "published_date": "string",
  "description": "string",
  "page_count": "integer",
  "categories": "string",
  "lenguage": "string",
  "thumbnail_url": "string",
  "author": "Author"
}
```

### Miembro
```json
{
  "id": "long",
  "first_name": "string",
  "last_name": "string",
  "email": "string",
  "phone": "string",
  "address": "string"
}
```

### Préstamo
```json
{
  "id": "long",
  "loan_date": "string",
  "return_date": "string",
  "returned_date": "string",
  "book": "Book",
  "member": "Member"
}
```

### Autor
```json
{
  "id": "long",
  "name": "string"
}
```

## Configuración

1. Asegúrese de tener Java y Maven instalados
2. Clone el repositorio `git clone https://github.com/fer-gc05/Library-Management.git`
3. Ejecute `mvn clean install`
4. Inicie la aplicación con `java -jar target/library-system.jar`
5. Acceda a la API en `http://localhost:8080/swagger-ui/index.html#/`

## Requisitos de la API
- Java 17
- Todas las peticiones deben incluir el encabezado `Accept: application/json`
- Los cuerpos de petición/respuesta utilizan formato JSON
- **Spring Boot v3.4.1** para el correcto funcionamiento de la API

## Próximamente
- ~**Configuración de CORS**: Gestión de acceso seguro para solicitudes desde diferentes orígenes.~ ✅
- **Desarrollo de la App Frontend**: Creación de una interfaz de usuario accesible para interactuar con la API.
- **Consumo de la API mediante la app frontend**: Implementación de las solicitudes y manejo de los datos desde el frontend hacia la API.
