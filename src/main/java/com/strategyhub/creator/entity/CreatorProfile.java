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

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "creator_profiles")
public class CreatorProfile {

    @Id
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "creator_id", nullable = false)
    private Creator creator;

    @Column(name = "goals_12_months", columnDefinition = "TEXT", nullable = false)
    private String goals12Months;

    @Column(name = "dream_outcome", columnDefinition = "TEXT", nullable = false)
    private String dreamOutcome;

    @Column(name = "biggest_struggle", columnDefinition = "TEXT", nullable = false)
    private String biggestStruggle;

    @Column(name = "biggest_win", columnDefinition = "TEXT", nullable = false)
    private String biggestWin;

    @Column(name = "turning_point", columnDefinition = "TEXT", nullable = false)
    private String turningPoint;

    @Column(name = "additional_interests", columnDefinition = "TEXT")
    private String additionalInterests;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected CreatorProfile() {
    }

    public CreatorProfile(Creator creator, String goals12Months, String dreamOutcome,
                          String biggestStruggle, String biggestWin, String turningPoint) {
        this.creator = creator;
        this.goals12Months = goals12Months;
        this.dreamOutcome = dreamOutcome;
        this.biggestStruggle = biggestStruggle;
        this.biggestWin = biggestWin;
        this.turningPoint = turningPoint;
    }

    public CreatorProfile(Creator creator, String goals12Months, String dreamOutcome,
                          String biggestStruggle, String biggestWin, String turningPoint,
                          String additionalInterests) {
        this.creator = creator;
        this.goals12Months = goals12Months;
        this.dreamOutcome = dreamOutcome;
        this.biggestStruggle = biggestStruggle;
        this.biggestWin = biggestWin;
        this.turningPoint = turningPoint;
        this.additionalInterests = additionalInterests;
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

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public String getGoals12Months() {
        return goals12Months;
    }

    public void setGoals12Months(String goals12Months) {
        this.goals12Months = goals12Months;
    }

    public String getDreamOutcome() {
        return dreamOutcome;
    }

    public void setDreamOutcome(String dreamOutcome) {
        this.dreamOutcome = dreamOutcome;
    }

    public String getBiggestStruggle() {
        return biggestStruggle;
    }

    public void setBiggestStruggle(String biggestStruggle) {
        this.biggestStruggle = biggestStruggle;
    }

    public String getBiggestWin() {
        return biggestWin;
    }

    public void setBiggestWin(String biggestWin) {
        this.biggestWin = biggestWin;
    }

    public String getTurningPoint() {
        return turningPoint;
    }

    public void setTurningPoint(String turningPoint) {
        this.turningPoint = turningPoint;
    }

    public String getAdditionalInterests() {
        return additionalInterests;
    }

    public void setAdditionalInterests(String additionalInterests) {
        this.additionalInterests = additionalInterests;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
