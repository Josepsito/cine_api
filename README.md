# 🎬 Cine API - Spring Boot RESTful Service

Una API REST para gestionar películas, directores y actores. Hecho con **Spring Boot**, **JPA/Hibernate**, y **MySQL**.

## 📦 Features

CRUD operations for movies, directors, and actors

- Association of movies with actors and directors
- Support for genres and formats
- Validation with Jakarta Bean Validation
- CORS enabled for any origin
- Documentation with Swagger (optional)
- Database can be initialized with schema.sql and data.sql
## 🚀 Technologies

- Java 21
- Spring Boot
- Spring Data JPA
- Caffeine
- MySQL
- Lombok
- Hibernate
- Validation
- Maven

## 🏗️ Project Structure
```
src/
├── controller/
├── service/
├── dto/
├── model/
├── repository/
└── config/
```

## 🛠️ Configuration

Before running the application, you must rename the file application.properties.example to application.properties and fill in your actual database credentials:

```bash
src/main/resources/application.properties.example ➜ application.properties
```

Make sure you have a MySQL database running and configure your application.properties:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cine
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```
⚠️ Important: Do not leave your real credentials in the example file. Keep application.properties out of version control by using .gitignore.

## 📸 Examples

### Create a Movie (POST /api/movie)

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
  "formats": ["IMAX", "Digital"],
  "directorIds": [1],
  "actorIds": [1, 2]
}
```

## ✅ How to Upload to GitHub
- Initialize git:

```bash
git init
git add .
git commit -m "Initial commit"
```

- Create a repository on GitHub

- Add the remote:

```bash
git remote add origin https://github.com/tu-usuario/tu-repo.git
git push -u origin main
```

## ✅ CORS y Seguridad

All security has been disabled to allow public testing:

```
http.csrf().disable().authorizeHttpRequests().anyRequest().permitAll();
```
```
.authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
```

## 📌 Documentación de la API
You can access the Swagger-generated documentation once the project is running at:
```
http://localhost:8080/swagger-ui/index.html
```