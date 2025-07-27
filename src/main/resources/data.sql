
INSERT INTO director (id, name, birth_date, nationality, biography, photo_url)
VALUES
  (1, 'Christopher Nolan', '1970-07-30', 'British-American', 'Known for complex and non-linear storytelling.', 'https://cdn.britannica.com/37/255737-050-9BB3FEDA/Christopher-Nolan-Movie-film-director-Oppenheimer-UK-premiere-2023.jpg'),
  (2, 'Quentin Tarantino', '1963-03-27', 'American', 'Famous for stylized violence and nonlinear storylines.', 'https://sm.ign.com/t/ign_es/news/q/quentin-ta/quentin-tarantino-was-reportedly-toying-with-a-goodbye-meta_razn.1280.jpg');

INSERT INTO actor (id, name, birth_date, nationality, biography, photo_url)
VALUES
  (1, 'Leonardo DiCaprio', '1974-11-11', 'American', 'Known for Titanic and Inception.', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTMkNVtHPGOHXyWtRlwxXlKfp0UomAHHGWly7bOrjPhrP4KKpf5bVtYYXVczeHWB8Ics9Xx69wsbCEQBuOK16u7dA'),
  (2, 'Christian Bale', '1974-01-30', 'British', 'Known for The Dark Knight Trilogy.', 'https://static.wikia.nocookie.net/marvel_dc/images/1/1b/Christian_Bale_Mug_2.jpg/revision/latest/thumbnail/width/360/height/360?cb=20190930215347'),
  (3, 'Brad Pitt', '1963-12-18', 'American', 'Known for Fight Club and Once Upon a Time in Hollywood.', 'https://resizer.glanacion.com/resizer/v2/en-una-reciente-entrevista-brad-pitt-recordo-como-5E7KB4PSJJAYJLBRLNPLJE22TI.jpg?auth=a8863d0e04a3a03178853954fc571147b841008c6883e08a10b2f951a51ae566&width=1200&quality=70&smart=false&height=800');

INSERT INTO movie (id, title, description, duration, rating, subtitled, release_date, image_url, trailer_url, status, score)
VALUES
  (1, 'Inception', 'A mind-bending thriller about dreams within dreams.', 148, 'PG-13', true, '2010-07-16', 'https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg', 'https://www.youtube.com/watch?v=YoHD9XEInc0', 'Released', 8.8),
  (2, 'The Dark Knight', 'Batman faces the Joker in this gritty action film.', 152, 'PG-13', false, '2008-07-18', 'https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_FMjpg_UX1000_.jpg', 'https://www.youtube.com/watch?v=EXeTwQWrcwY', 'Released', 9.0),
  (3, 'Once Upon a Time in Hollywood', 'A faded actor and his stunt double navigate 1969 Hollywood.', 161, 'R', true, '2019-07-26', 'https://m.media-amazon.com/images/M/MV5BN2IwMmVmOTktMWNiMi00NjFiLThlZDUtMDAyOGZiNmJjM2ExXkEyXkFqcGc@._V1_.jpg', 'https://www.youtube.com/watch?v=ELeMaP8EPAA', 'Released', 7.6);

INSERT INTO movie_genres (movie_id, genre)
VALUES
  (1, 'Sci-Fi'), (1, 'Thriller'),
  (2, 'Action'), (2, 'Crime'),
  (3, 'Drama'), (3, 'Comedy');

INSERT INTO movie_formats (movie_id, format)
VALUES
  (1, 'IMAX'), (1, '2D'),
  (2, '4K'), (2, '2D'),
  (3, '2D');

INSERT INTO movie_directors (movie_id, directors_id)
VALUES
  (1, 1),  -- Inception → Nolan
  (2, 1),  -- The Dark Knight → Nolan
  (3, 2);  -- Once Upon a Time → Tarantino


INSERT INTO movie_actors (movie_id, actors_id)
VALUES
  (1, 1),  -- Inception → DiCaprio
  (2, 2),  -- Dark Knight → Bale
  (3, 3),  -- Once Upon → Pitt
  (3, 1);  -- Once Upon → DiCaprio
