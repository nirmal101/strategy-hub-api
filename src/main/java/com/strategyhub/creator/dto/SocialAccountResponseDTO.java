package com.strategyhub.creator.dto;

import java.util.Objects;

public class SocialAccountResponseDTO {

    private final String platform;
    private final String profileUrl;

    public SocialAccountResponseDTO(String platform, String profileUrl) {
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
        SocialAccountResponseDTO that = (SocialAccountResponseDTO) o;
        return Objects.equals(platform, that.platform) && Objects.equals(profileUrl, that.profileUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platform, profileUrl);
    }
}

