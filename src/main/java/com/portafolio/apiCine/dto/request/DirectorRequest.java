package com.portafolio.apiCine.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DirectorRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @NotBlank(message = "Nationality is required")
    private String nationality;

    @Size(max = 1000, message = "Biography must not exceed 1000 characters")
    private String biography;

    @URL(message = "Must be a valid URL")
    private String photoUrl;
}
