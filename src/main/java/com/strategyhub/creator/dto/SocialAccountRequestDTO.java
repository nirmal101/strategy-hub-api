package com.strategyhub.creator.dto;

import java.util.Objects;

/**
 * DTO for a single social account in the intake payload.
 */
public class SocialAccountRequestDTO {

    private final String platform;
    private final String profileUrl;

    public SocialAccountRequestDTO(String platform, String profileUrl) {
        this.platform = platform;
        this.profileUrl = profileUrl;
    }

    public String getPlatform() {
        return platform;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialAccountRequestDTO that = (SocialAccountRequestDTO) o;
        return Objects.equals(platform, that.platform) && Objects.equals(profileUrl, that.profileUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platform, profileUrl);
    }
}
