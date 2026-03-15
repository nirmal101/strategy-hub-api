package com.strategyhub.creator.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * DTO for the vision section of the creator intake payload.
 */
public class VisionSectionDTO {

    @NotBlank
    @Size(max = 2000)
    private final String goals12Months;

    @NotBlank
    @Size(max = 2000)
    private final String dreamOutcome;

    public VisionSectionDTO(String goals12Months, String dreamOutcome) {
        this.goals12Months = goals12Months;
        this.dreamOutcome = dreamOutcome;
    }

    public String getGoals12Months() {
        return goals12Months;
    }

    public String getDreamOutcome() {
        return dreamOutcome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisionSectionDTO that = (VisionSectionDTO) o;
        return Objects.equals(goals12Months, that.goals12Months)
                && Objects.equals(dreamOutcome, that.dreamOutcome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goals12Months, dreamOutcome);
    }
}
