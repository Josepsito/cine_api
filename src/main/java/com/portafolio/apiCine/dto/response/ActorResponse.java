package com.portafolio.apiCine.dto.response;

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
public class ActorResponse {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String nationality;
    private String biography;
    private String photoUrl;
    private Integer birthyear;
    private Set<Long> movieIds;


}