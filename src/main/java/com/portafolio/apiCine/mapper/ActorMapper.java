package com.portafolio.apiCine.mapper;

import com.portafolio.apiCine.dto.request.ActorRequest;
import com.portafolio.apiCine.dto.response.ActorResponse;
import com.portafolio.apiCine.model.Actor;
import com.portafolio.apiCine.model.Movie;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ActorMapper {

    public Actor toEntity(ActorRequest request) {
        Actor actor = new Actor();
        actor.setName(request.getName());
        actor.setBirthDate(request.getBirthDate());
        actor.setNationality(request.getNationality());
        actor.setBiography(request.getBiography());
        actor.setPhotoUrl(request.getPhotoUrl());

        return actor;
    }

    public ActorResponse toResponse(Actor actor) {
        ActorResponse response = new ActorResponse();
        response.setId(actor.getId());
        response.setName(actor.getName());
        response.setBirthDate(actor.getBirthDate());
        response.setNationality(actor.getNationality());
        response.setBiography(actor.getBiography());
        response.setPhotoUrl(actor.getPhotoUrl());

        response.setMovieIds(
                actor.getMovies().stream()
                        .map(Movie::getId)
                        .collect(Collectors.toSet())
        );
        return response;
    }
}
