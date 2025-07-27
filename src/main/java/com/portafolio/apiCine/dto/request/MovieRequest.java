package com.portafolio.apiCine.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be greater than 0")
    private Integer duration;

    private String rating;

    private boolean subtitled;

    @NotNull(message = "Release date is required")
    private LocalDate releaseDate;

    @URL(message = "Must be a valid URL")
    private String imageUrl;

    @URL(message = "Must be a valid URL")
    private String trailerUrl;

    private String status;

    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private double score;

    private Set<String> genres;

    private Set<String> formats;

    private Set<Long> directorIds;

    private Set<Long> actorIds;
}
