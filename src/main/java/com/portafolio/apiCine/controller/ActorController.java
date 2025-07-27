package com.portafolio.apiCine.controller;

import com.portafolio.apiCine.dto.request.ActorRequest;
import com.portafolio.apiCine.dto.response.ActorResponse;
import com.portafolio.apiCine.service.ActorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/actor")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public List<ActorResponse> getAll() {
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public ActorResponse getById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @PostMapping
    public ActorResponse create(@Valid @RequestBody ActorRequest request) {
        return actorService.createActor(request);
    }

    @PutMapping("/{id}")
    public ActorResponse update(@PathVariable Long id, @Valid @RequestBody ActorRequest request) {
        return actorService.updateActor(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        actorService.deleteActor(id);
    }
}