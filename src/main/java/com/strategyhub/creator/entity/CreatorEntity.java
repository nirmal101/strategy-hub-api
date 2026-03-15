package com.strategyhub.creator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(
    name = "creators",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class CreatorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "niche", nullable = false)
    private String niche;

    @Column(name = "stage", nullable = false)
    private String stage;

    @Column(name = "age")
    private Integer age;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected CreatorEntity() {
    }

    public CreatorEntity(String email, String category, String niche, String stage) {
        this.email = email;
        this.category = category;
        this.niche = niche;
        this.stage = stage;
    }

    public CreatorEntity(String email, String category, String niche, String stage, Integer age) {
        this.email = email;
        this.category = category;
        this.niche = niche;
        this.stage = stage;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNiche() {
        return niche;
    }

    public void setNiche(String niche) {
        this.niche = niche;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
