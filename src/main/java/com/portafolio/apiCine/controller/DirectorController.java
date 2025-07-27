package com.portafolio.apiCine.controller;

import com.portafolio.apiCine.dto.request.DirectorRequest;
import com.portafolio.apiCine.dto.response.DirectorResponse;
import com.portafolio.apiCine.service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping
    public List<DirectorResponse> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @GetMapping("/{id}")
    public DirectorResponse getDirectorById(@PathVariable Long id) {
        return directorService.getDirectorById(id);
    }

    @PostMapping
    public DirectorResponse createDirector(@Valid @RequestBody DirectorRequest request) {
        return directorService.createDirector(request);
    }

    @PutMapping("/{id}")
    public DirectorResponse updateDirector(@PathVariable Long id, @Valid @RequestBody DirectorRequest request) {
        return directorService.updateDirector(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable Long id) {
        directorService.deleteDirector(id);
    }
}
