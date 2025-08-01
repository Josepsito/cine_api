> To view this documentation in Spanish, visit README.es.md

# 🎬 Cine API - Spring Boot RESTful Service

Una API REST para gestionar películas, directores y actores. Hecho con **Spring Boot**, **JPA/Hibernate**, y **MySQL**.

## 📦 Características

- CRUD de películas, directores y actores
- Asociación de películas con actores y directores
- Soporte para géneros y formatos
- Validaciones con Jakarta Bean Validation
- CORS habilitado para cualquier origen
- Documentación con Swagger (opcional)
- Base de datos inicializable con `schema.sql` y `data.sql`

## 🚀 Tecnologías

- Java 21
- Spring Boot
- Spring Data JPA
- Caffeine
- MySQL
- Lombok
- Hibernate
- Validation
- Maven

## 🏗️ Estructura del proyecto
```
src/
├── controller/
├── service/
├── dto/
├── model/
├── repository/
└── config/
```

## 🛠️ Configuración

Antes de correr la aplicacion renombra el archivo application.properties.example por application.properties:
```bash
src/main/resources/application.properties.example ➜ application.properties
```

Asegúrate de tener una base de datos MySQL corriendo y configurar `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cine_db?useSSL=false&serverTimezone=UTC&createDatabaseIfNotExist=true
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=create-drop
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## 🔐 Reemplaza "your-username" y "your-password" con tus credenciales reales de MySQL
spring.datasource.username=your-username
spring.datasource.password=your-password

✅ Recomendación: Cámbia "create-drop" por update o none para no perder los datos.

⚠️ Importante: No dejes tus credenciales reales en el archivo de ejemplo. Mantén application.properties fuera del control de versiones usando .gitignore.

## 📸 Ejemplos

### Crear una película (POST `/api/movie`)

```json
{
  "title": "Inception",
  "description": "A mind-bending thriller about dreams within dreams.",
  "duration": 148,
  "rating": "PG-13",
  "subtitled": true,
  "releaseDate": "2010-07-16",
  "imageUrl": "https://upload.wikimedia.org/wikipedia/en/7/7f/Inception_ver3.jpg",
  "trailerUrl": "https://www.youtube.com/watch?v=YoHD9XEInc0",
  "status": "Released",
  "score": 8.8,
  "genres": ["Sci-Fi", "Thriller"],
  "formats": ["IMAX", "Digital"]
}
```

## ✅ Cómo subir a GitHub
- Inicializa git:

```bash
git init
git add .
git commit -m "Initial commit"
```

- Crea un repositorio en GitHub


- Añade el remoto:

```bash
git remote add origin https://github.com/tu-usuario/tu-repo.git
git push -u origin main
```

## ✅ CORS y Seguridad

Toda la seguridad ha sido deshabilitada para facilitar pruebas públicas:

```
http.csrf().disable().authorizeHttpRequests().anyRequest().permitAll();
```
```
.authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
```

## 📌 Documentación de la API
Puedes acceder al enlace
para ver la documentacion generada por Swagger una vez inicializado el proyecto.
```
http://localhost:8080/swagger-ui/index.html
```

## 🪪 Licencia

Este proyecto está licenciado bajo la licencia [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/) license.