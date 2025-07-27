CREATE DATABASE IF NOT EXISTS cine_db;
USE cine_db;

-- Tabla actor
CREATE TABLE actor (
    id BIGINT PRIMARY KEY,
    biography VARCHAR(255),
    birth_date DATE,
    name VARCHAR(255),
    nationality VARCHAR(255),
    photo_url VARCHAR(255)
);

-- Tabla director
CREATE TABLE director (
    id BIGINT PRIMARY KEY,
    biography VARCHAR(255),
    birth_date DATE,
    name VARCHAR(255),
    nationality VARCHAR(255),
    photo_url VARCHAR(255)
);

-- Tabla movie
CREATE TABLE movie (
    id BIGINT PRIMARY KEY,
    description VARCHAR(1000),
    duration INT,
    image_url VARCHAR(255),
    rating VARCHAR(255),
    release_date DATE,
    score DOUBLE,
    status VARCHAR(255),
    subtitled BIT,
    title VARCHAR(255),
    trailer_url VARCHAR(255)
);

-- Tabla movie_actors (relación N:N entre movie y actor)
CREATE TABLE movie_actors (
    movies_id BIGINT,
    actors_id BIGINT,
    PRIMARY KEY (movies_id, actors_id),
    FOREIGN KEY (movies_id) REFERENCES movie(id),
    FOREIGN KEY (actors_id) REFERENCES actor(id)
);

-- Tabla movie_directors (relación N:N entre movie y director)
CREATE TABLE movie_directors (
    directed_movies_id BIGINT,
    directors_id BIGINT,
    PRIMARY KEY (directed_movies_id, directors_id),
    FOREIGN KEY (directed_movies_id) REFERENCES movie(id),
    FOREIGN KEY (directors_id) REFERENCES director(id)
);

-- Tabla movie_formats
CREATE TABLE movie_formats (
    movie_id BIGINT,
    format VARCHAR(255),
    PRIMARY KEY (movie_id, format),
    FOREIGN KEY (movie_id) REFERENCES movie(id)
);

-- Tabla movie_genres
CREATE TABLE movie_genres (
    movie_id BIGINT,
    genre VARCHAR(255),
    PRIMARY KEY (movie_id, genre),
    FOREIGN KEY (movie_id) REFERENCES movie(id)
);
