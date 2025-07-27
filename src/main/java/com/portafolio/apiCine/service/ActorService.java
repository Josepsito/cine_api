package com.portafolio.apiCine.service;

import com.portafolio.apiCine.dto.request.ActorRequest;
import com.portafolio.apiCine.dto.response.ActorResponse;

import com.portafolio.apiCine.mapper.ActorMapper;
import com.portafolio.apiCine.model.Actor;

import com.portafolio.apiCine.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    public List<ActorResponse> getAllActors() {
        return actorRepository.findAll()
                .stream()
                .map(actorMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ActorResponse getActorById(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new RuntimeException("Actor not found"));
        return actorMapper.toResponse(actor);
    }

    public ActorResponse createActor(ActorRequest request) {
        Actor actor = actorMapper.toEntity(request);
        return actorMapper.toResponse(actorRepository.save(actor));
    }

    public ActorResponse updateActor(Long id, ActorRequest request) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new RuntimeException("Actor not found"));
        actor.setName(request.getName());
        actor.setBirthDate(request.getBirthDate());
        actor.setNationality(request.getNationality());
        actor.setBiography(request.getBiography());
        actor.setPhotoUrl(request.getPhotoUrl());
        return actorMapper.toResponse(actorRepository.save(actor));
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
