package com.strategyhub.creator.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

/**
 * DTO for the content reality section of the creator intake payload.
 */
public class ContentRealitySectionDTO {

    @NotNull
    @Size(min = 1)
    private final List<String> priorities;

    @NotBlank
    private final String cameraComfort;

    @NotBlank
    private final String postingFrequency;

    @NotNull
    @Min(0)
    private final Integer totalFollowers;

    public ContentRealitySectionDTO(List<String> priorities, String cameraComfort, String postingFrequency, Integer totalFollowers) {
        this.priorities = priorities;
        this.cameraComfort = cameraComfort;
        this.postingFrequency = postingFrequency;
        this.totalFollowers = totalFollowers;
    }

    public List<String> getPriorities() {
        return priorities;
    }

    public String getCameraComfort() {
        return cameraComfort;
    }

    public String getPostingFrequency() {
        return postingFrequency;
    }

    public Integer getTotalFollowers() {
        return totalFollowers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentRealitySectionDTO that = (ContentRealitySectionDTO) o;
        return Objects.equals(priorities, that.priorities)
                && Objects.equals(cameraComfort, that.cameraComfort)
                && Objects.equals(postingFrequency, that.postingFrequency)
                && Objects.equals(totalFollowers, that.totalFollowers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priorities, cameraComfort, postingFrequency, totalFollowers);
    }
}
