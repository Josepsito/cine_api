package com.portafolio.apiCine.service;

import com.portafolio.apiCine.dto.request.MovieRequest;
import com.portafolio.apiCine.dto.response.MovieResponse;
import com.portafolio.apiCine.mapper.MovieMapper;
import com.portafolio.apiCine.model.Actor;
import com.portafolio.apiCine.model.Director;
import com.portafolio.apiCine.model.Movie;
import com.portafolio.apiCine.repository.ActorRepository;
import com.portafolio.apiCine.repository.DirectorRepository;
import com.portafolio.apiCine.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final ActorRepository actorRepository;
    private final MovieMapper movieMapper;

    @Cacheable("allMovies")
    public List<MovieResponse> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(movieMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Cacheable("movies")
    public MovieResponse getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with ID: " + id));
        return movieMapper.toResponse(movie);
    }

    @CacheEvict(value = {"allMovies", "movies"}, allEntries = true)
    public MovieResponse createMovie(MovieRequest request) {
        Movie movie = buildMovieFromRequest(request, new Movie());
        return movieMapper.toResponse(movieRepository.save(movie));
    }

    @CacheEvict(value = {"allMovies", "movies"}, allEntries = true)
    public MovieResponse updateMovie(Long id, MovieRequest request) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with ID: " + id));
        movie = buildMovieFromRequest(request, movie);
        return movieMapper.toResponse(movieRepository.save(movie));
    }

    @CacheEvict(value = {"allMovies", "movies"}, allEntries = true)
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    private Movie buildMovieFromRequest(MovieRequest request, Movie movie) {
        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        movie.setDuration(request.getDuration());
        movie.setRating(request.getRating());
        movie.setSubtitled(request.isSubtitled());
        movie.setReleaseDate(request.getReleaseDate());
        movie.setImageUrl(request.getImageUrl());
        movie.setTrailerUrl(request.getTrailerUrl());
        movie.setStatus(request.getStatus());
        movie.setScore(request.getScore());
        movie.setGenres(request.getGenres());
        movie.setFormats(request.getFormats());

        if (request.getDirectorIds() != null && !request.getDirectorIds().isEmpty()) {
            Set<Director> directors = request.getDirectorIds().stream()
                    .map(directorId -> directorRepository.findById(directorId)
                            .orElseThrow(() -> new RuntimeException("Director not found with ID: " + directorId)))
                    .collect(Collectors.toSet());
            movie.setDirectors(directors);
        } else {
            movie.setDirectors(null);
        }

        if (request.getActorIds() != null && !request.getActorIds().isEmpty()) {
            Set<Actor> actors = request.getActorIds().stream()
                    .map(actorId -> actorRepository.findById(actorId)
                            .orElseThrow(() -> new RuntimeException("Actor not found with ID: " + actorId)))
                    .collect(Collectors.toSet());
            movie.setActors(actors);
        } else {
            movie.setActors(null);
        }

        return movie;
    }
}
