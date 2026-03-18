package com.strategyhub.creator.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * DTO for the narrative section of the creator intake payload.
 */
public class NarrativeSectionDTO {

    @NotBlank
    @Size(max = 2000)
    private final String biggestStruggle;

    @NotBlank
    @Size(max = 2000)
    private final String biggestWin;

    @NotBlank
    @Size(max = 2000)
    private final String turningPoint;

    @Size(max = 2000)
    private final String additionalInterests;

    public NarrativeSectionDTO(String biggestStruggle, String biggestWin, String turningPoint, String additionalInterests) {
        this.biggestStruggle = biggestStruggle;
        this.biggestWin = biggestWin;
        this.turningPoint = turningPoint;
        this.additionalInterests = additionalInterests;
    }

    public String getBiggestStruggle() {
        return biggestStruggle;
    }

    public String getBiggestWin() {
        return biggestWin;
    }

    public String getTurningPoint() {
        return turningPoint;
    }

    public String getAdditionalInterests() {
        return additionalInterests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NarrativeSectionDTO that = (NarrativeSectionDTO) o;
        return Objects.equals(biggestStruggle, that.biggestStruggle)
                && Objects.equals(biggestWin, that.biggestWin)
                && Objects.equals(turningPoint, that.turningPoint)
                && Objects.equals(additionalInterests, that.additionalInterests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(biggestStruggle, biggestWin, turningPoint, additionalInterests);
    }
}
