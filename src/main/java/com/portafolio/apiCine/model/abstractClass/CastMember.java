package com.portafolio.apiCine.model.abstractClass;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public abstract class CastMember {
    private String name;
    private LocalDate birthDate;
    private String nationality;
    private String biography;
    private String photoUrl;
}
