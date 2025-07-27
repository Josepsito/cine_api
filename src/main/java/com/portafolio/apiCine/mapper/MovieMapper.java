package com.portafolio.apiCine.mapper;

import com.portafolio.apiCine.dto.response.MovieResponse;
import com.portafolio.apiCine.model.Actor;
import com.portafolio.apiCine.model.Director;
import com.portafolio.apiCine.model.Movie;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    public MovieResponse toResponse(Movie movie) {
        MovieResponse response = new MovieResponse();

        response.setId(movie.getId());
        response.setTitle(movie.getTitle());
        response.setDescription(movie.getDescription());
        response.setDuration(movie.getDuration());
        response.setRating(movie.getRating());
        response.setSubtitled(movie.isSubtitled());
        response.setReleaseDate(movie.getReleaseDate());
        response.setImageUrl(movie.getImageUrl());
        response.setTrailerUrl(movie.getTrailerUrl());
        response.setStatus(movie.getStatus());
        response.setScore(movie.getScore());
        response.setGenres(movie.getGenres());
        response.setFormats(movie.getFormats());

        if (movie.getDirectors() != null) {
            response.setDirectorIds(
                    movie.getDirectors().stream()
                            .map(Director::getId)
                            .collect(Collectors.toSet())
            );
        }else{
            response.setDirectorIds(new HashSet<>());
        }

        if (movie.getActors() != null) {
            response.setActorIds(
                    movie.getActors().stream()
                            .map(Actor::getId)
                            .collect(Collectors.toSet())
            );
        }else{
            response.setActorIds(new HashSet<>());
        }

        return response;
    }
}
