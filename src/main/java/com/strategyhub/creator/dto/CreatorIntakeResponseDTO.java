package com.strategyhub.creator.dto;

import java.util.Objects;
import java.util.UUID;

/**
 * Response DTO returned after creating a creator from the intake payload.
 */
public class CreatorIntakeResponseDTO {

    private final UUID creatorId;

    public CreatorIntakeResponseDTO(UUID creatorId) {
        this.creatorId = creatorId;
    }

    public UUID getCreatorId() {
        return creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatorIntakeResponseDTO that = (CreatorIntakeResponseDTO) o;
        return Objects.equals(creatorId, that.creatorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creatorId);
    }
}
