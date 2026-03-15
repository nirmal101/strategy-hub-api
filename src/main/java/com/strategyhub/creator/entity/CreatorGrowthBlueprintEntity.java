package com.strategyhub.creator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "creator_growth_blueprints")
public class CreatorGrowthBlueprintEntity {

    @Id
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "creator_id", nullable = false)
    private CreatorEntity creator;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "priorities", columnDefinition = "jsonb", nullable = false)
    private List<String> priorities;

    @Column(name = "camera_comfort", nullable = false)
    private String cameraComfort;

    @Column(name = "posting_frequency", nullable = false)
    private String postingFrequency;

    @Column(name = "total_followers", nullable = false)
    private Integer totalFollowers;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected CreatorGrowthBlueprintEntity() {
    }

    public CreatorGrowthBlueprintEntity(CreatorEntity creator, List<String> priorities,
                                        String cameraComfort, String postingFrequency, Integer totalFollowers) {
        this.creator = creator;
        this.priorities = priorities;
        this.cameraComfort = cameraComfort;
        this.postingFrequency = postingFrequency;
        this.totalFollowers = totalFollowers;
    }

    @PrePersist
    void onPersist() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public CreatorEntity getCreator() {
        return creator;
    }

    public void setCreator(CreatorEntity creator) {
        this.creator = creator;
    }

    public List<String> getPriorities() {
        return priorities;
    }

    public void setPriorities(List<String> priorities) {
        this.priorities = priorities;
    }

    public String getCameraComfort() {
        return cameraComfort;
    }

    public void setCameraComfort(String cameraComfort) {
        this.cameraComfort = cameraComfort;
    }

    public String getPostingFrequency() {
        return postingFrequency;
    }

    public void setPostingFrequency(String postingFrequency) {
        this.postingFrequency = postingFrequency;
    }

    public Integer getTotalFollowers() {
        return totalFollowers;
    }

    public void setTotalFollowers(Integer totalFollowers) {
        this.totalFollowers = totalFollowers;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
