package com.portafolio.apiCine.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
    private Long id;
    private String title;
    private String description;
    private Integer duration;
    private String rating;
    private boolean subtitled;
    private LocalDate releaseDate;
    private String imageUrl;
    private String trailerUrl;
    private String status;
    private double score;
    private Set<String> genres;
    private Set<String> formats;
    private Set<Long> directorIds;
    private Set<Long> actorIds;
}

