package com.portafolio.apiCine.repository;

import com.portafolio.apiCine.model.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    @EntityGraph(attributePaths = {"directors", "actors"})
    List<Movie> findAll();

    @EntityGraph(attributePaths = {"directors", "actors"})
    Optional<Movie> findById(Long id);;

}
