package com.portafolio.apiCine.mapper;

import com.portafolio.apiCine.dto.request.DirectorRequest;
import com.portafolio.apiCine.dto.response.DirectorResponse;
import com.portafolio.apiCine.model.Director;
import com.portafolio.apiCine.model.Movie;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DirectorMapper {

    public Director toEntity(DirectorRequest request) {
        Director director = new Director();
        director.setName(request.getName());
        director.setBirthDate(request.getBirthDate());
        director.setNationality(request.getNationality());
        director.setBiography(request.getBiography());
        director.setPhotoUrl(request.getPhotoUrl());
        return director;
    }

    public DirectorResponse toResponse(Director director) {
        DirectorResponse response = new DirectorResponse();
        response.setId(director.getId());
        response.setName(director.getName());
        response.setBirthDate(director.getBirthDate());
        response.setNationality(director.getNationality());
        response.setBiography(director.getBiography());
        response.setPhotoUrl(director.getPhotoUrl());

        response.setDirectedMovieIds(
                director.getDirectedMovies().stream()
                        .map(Movie::getId)
                        .collect(Collectors.toSet())
        );
        return response;
    }
}
