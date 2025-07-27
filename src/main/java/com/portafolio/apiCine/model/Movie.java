package com.portafolio.apiCine.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private Integer duration;

    private String rating;

    private boolean subtitled;

    private LocalDate releaseDate;

    private String imageUrl;

    private String trailerUrl;

    private String status;

    private double score;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    private Set<String> genres;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "movie_formats", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "format")
    private Set<String> formats;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Director> directors;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Actor> actors;
}