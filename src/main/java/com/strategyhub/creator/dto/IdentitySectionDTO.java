package com.strategyhub.creator.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

/**
 * DTO for the identity section of the creator intake payload.
 */
public class IdentitySectionDTO {

    @NotBlank
    @Email
    private final String email;

    @NotBlank
    private final String category;

    @NotBlank
    private final String niche;

    @NotBlank
    private final String stage;

    private final Integer age;

    public IdentitySectionDTO(String email, String category, String niche, String stage, Integer age) {
        this.email = email;
        this.category = category;
        this.niche = niche;
        this.stage = stage;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public String getCategory() {
        return category;
    }

    public String getNiche() {
        return niche;
    }

    public String getStage() {
        return stage;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentitySectionDTO that = (IdentitySectionDTO) o;
        return Objects.equals(email, that.email)
                && Objects.equals(category, that.category)
                && Objects.equals(niche, that.niche)
                && Objects.equals(stage, that.stage)
                && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, category, niche, stage, age);
    }
}
