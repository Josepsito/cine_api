package com.portafolio.apiCine.service;

import com.portafolio.apiCine.dto.request.DirectorRequest;
import com.portafolio.apiCine.dto.response.DirectorResponse;
import com.portafolio.apiCine.mapper.DirectorMapper;
import com.portafolio.apiCine.model.Director;
import com.portafolio.apiCine.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    public List<DirectorResponse> getAllDirectors() {
        return directorRepository.findAll().stream()
                .map(directorMapper::toResponse)
                .collect(Collectors.toList());
    }

    public DirectorResponse getDirectorById(Long id) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Director not found"));
        return directorMapper.toResponse(director);
    }

    public DirectorResponse createDirector(DirectorRequest request) {
        Director director = directorMapper.toEntity(request);
        return directorMapper.toResponse(directorRepository.save(director));
    }

    public DirectorResponse updateDirector(Long id, DirectorRequest request) {
        Director director = directorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Director not found"));

        director.setName(request.getName());
        director.setBirthDate(request.getBirthDate());
        director.setNationality(request.getNationality());
        director.setBiography(request.getBiography());
        director.setPhotoUrl(request.getPhotoUrl());

        return directorMapper.toResponse(directorRepository.save(director));
    }

    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);
    }
}
