
--1
CREATE DATABASE cine_db;

--2
USE cine_db;


--3
CREATE TABLE movie (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(1000),
    duration INT,
    rating VARCHAR(255),
    subtitled BOOLEAN,
    release_date DATE,
    image_url VARCHAR(255),
    trailer_url VARCHAR(255),
    status VARCHAR(255),
    score DOUBLE
);

CREATE TABLE movie_genres (
    movie_id BIGINT NOT NULL,
    genre VARCHAR(255),
    FOREIGN KEY (movie_id) REFERENCES movie(id) ON DELETE CASCADE
);


CREATE TABLE movie_formats (
    movie_id BIGINT NOT NULL,
    format VARCHAR(255),
    FOREIGN KEY (movie_id) REFERENCES movie(id) ON DELETE CASCADE
);


CREATE TABLE director (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    birth_date DATE,
    nationality VARCHAR(255),
    biography TEXT,
    photo_url VARCHAR(255)
);


CREATE TABLE actor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    birth_date DATE,
    nationality VARCHAR(255),
    biography TEXT,
    photo_url VARCHAR(255)
);


CREATE TABLE movie_directors (
    movie_id BIGINT NOT NULL,
    directors_id BIGINT NOT NULL,
    PRIMARY KEY (movie_id, directors_id),
    FOREIGN KEY (movie_id) REFERENCES movie(id) ON DELETE CASCADE,
    FOREIGN KEY (directors_id) REFERENCES director(id)
);


CREATE TABLE movie_actors (
    movie_id BIGINT NOT NULL,
    actors_id BIGINT NOT NULL,
    PRIMARY KEY (movie_id, actors_id),
    FOREIGN KEY (movie_id) REFERENCES movie(id) ON DELETE CASCADE,
    FOREIGN KEY (actors_id) REFERENCES actor(id)
);
