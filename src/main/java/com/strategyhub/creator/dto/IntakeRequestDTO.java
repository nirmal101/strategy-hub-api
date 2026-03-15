package com.strategyhub.creator.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO representing the full intake payload.
 */
public class IntakeRequestDTO {

    // Creator
    private final String email;
    private final String category;
    private final String niche;
    private final String stage;
    private final Integer age;

    // CreatorProfile
    private final String goals12Months;
    private final String dreamOutcome;
    private final String biggestStruggle;
    private final String biggestWin;
    private final String turningPoint;
    private final String additionalInterests;

    // CreatorGrowthBlueprint
    private final List<String> priorities;
    private final String cameraComfort;
    private final String postingFrequency;
    private final Integer totalFollowers;

    // Social Accounts
    private final List<SocialAccountRequestDTO> socialAccounts;

    public IntakeRequestDTO(
            String email,
            String category,
            String niche,
            String stage,
            Integer age,
            String goals12Months,
            String dreamOutcome,
            String biggestStruggle,
            String biggestWin,
            String turningPoint,
            String additionalInterests,
            List<String> priorities,
            String cameraComfort,
            String postingFrequency,
            Integer totalFollowers,
            List<SocialAccountRequestDTO> socialAccounts) {
        this.email = email;
        this.category = category;
        this.niche = niche;
        this.stage = stage;
        this.age = age;
        this.goals12Months = goals12Months;
        this.dreamOutcome = dreamOutcome;
        this.biggestStruggle = biggestStruggle;
        this.biggestWin = biggestWin;
        this.turningPoint = turningPoint;
        this.additionalInterests = additionalInterests;
        this.priorities = priorities;
        this.cameraComfort = cameraComfort;
        this.postingFrequency = postingFrequency;
        this.totalFollowers = totalFollowers;
        this.socialAccounts = socialAccounts;
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

    public String getGoals12Months() {
        return goals12Months;
    }

    public String getDreamOutcome() {
        return dreamOutcome;
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

    public List<SocialAccountRequestDTO> getSocialAccounts() {
        return socialAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntakeRequestDTO that = (IntakeRequestDTO) o;
        return Objects.equals(email, that.email)
                && Objects.equals(category, that.category)
                && Objects.equals(niche, that.niche)
                && Objects.equals(stage, that.stage)
                && Objects.equals(age, that.age)
                && Objects.equals(goals12Months, that.goals12Months)
                && Objects.equals(dreamOutcome, that.dreamOutcome)
                && Objects.equals(biggestStruggle, that.biggestStruggle)
                && Objects.equals(biggestWin, that.biggestWin)
                && Objects.equals(turningPoint, that.turningPoint)
                && Objects.equals(additionalInterests, that.additionalInterests)
                && Objects.equals(priorities, that.priorities)
                && Objects.equals(cameraComfort, that.cameraComfort)
                && Objects.equals(postingFrequency, that.postingFrequency)
                && Objects.equals(totalFollowers, that.totalFollowers)
                && Objects.equals(socialAccounts, that.socialAccounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                email,
                category,
                niche,
                stage,
                age,
                goals12Months,
                dreamOutcome,
                biggestStruggle,
                biggestWin,
                turningPoint,
                additionalInterests,
                priorities,
                cameraComfort,
                postingFrequency,
                totalFollowers,
                socialAccounts);
    }
}
