package com.strategyhub.creator.service;

import com.strategyhub.creator.dto.CreatorResponseDTO;
import com.strategyhub.creator.dto.IntakeRequestDTO;
import com.strategyhub.creator.dto.SocialAccountResponseDTO;
import com.strategyhub.creator.dto.SocialAccountRequestDTO;
import com.strategyhub.creator.entity.CreatorEntity;
import com.strategyhub.creator.entity.CreatorGrowthBlueprintEntity;
import com.strategyhub.creator.entity.CreatorProfileEntity;
import com.strategyhub.creator.entity.CreatorSocialAccountEntity;
import com.strategyhub.creator.repository.CreatorGrowthBlueprintRepository;
import com.strategyhub.creator.repository.CreatorProfileRepository;
import com.strategyhub.creator.repository.CreatorRepository;
import com.strategyhub.creator.repository.CreatorSocialAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CreatorIntakeService {

    private final CreatorRepository creatorRepository;
    private final CreatorProfileRepository creatorProfileRepository;
    private final CreatorGrowthBlueprintRepository creatorGrowthBlueprintRepository;
    private final CreatorSocialAccountRepository creatorSocialAccountRepository;

    public CreatorIntakeService(
            CreatorRepository creatorRepository,
            CreatorProfileRepository creatorProfileRepository,
            CreatorGrowthBlueprintRepository creatorGrowthBlueprintRepository,
            CreatorSocialAccountRepository creatorSocialAccountRepository) {
        this.creatorRepository = creatorRepository;
        this.creatorProfileRepository = creatorProfileRepository;
        this.creatorGrowthBlueprintRepository = creatorGrowthBlueprintRepository;
        this.creatorSocialAccountRepository = creatorSocialAccountRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public UUID createCreator(IntakeRequestDTO request) {
        validateRequest(request);

        CreatorEntity creator = new CreatorEntity(
                request.getEmail(),
                request.getCategory(),
                request.getNiche(),
                request.getStage(),
                request.getAge()
        );
        creator = creatorRepository.save(creator);

        // Create CreatorProfile using the saved Creator
        CreatorProfileEntity profile = new CreatorProfileEntity(
                creator,
                request.getGoals12Months(),
                request.getDreamOutcome(),
                request.getBiggestStruggle(),
                request.getBiggestWin(),
                request.getTurningPoint(),
                request.getAdditionalInterests()
        );
        creatorProfileRepository.save(profile);

        // Create CreatorGrowthBlueprint using the saved Creator
        List<String> priorities = request.getPriorities() != null
                ? request.getPriorities()
                : Collections.emptyList();
        CreatorGrowthBlueprintEntity growthBlueprint = new CreatorGrowthBlueprintEntity(
                creator,
                priorities,
                request.getCameraComfort(),
                request.getPostingFrequency(),
                request.getTotalFollowers()
        );
        creatorGrowthBlueprintRepository.save(growthBlueprint);

        // Create and persist each social account (no cascade from Creator)
        List<SocialAccountRequestDTO> socialAccounts = request.getSocialAccounts();
        if (socialAccounts != null) {
            for (SocialAccountRequestDTO sa : socialAccounts) {
                if (isBlank(sa.getPlatform()) || isBlank(sa.getProfileUrl())) {
                    throw new IllegalArgumentException("Social account platform and profileUrl must not be blank");
                }
                CreatorSocialAccountEntity account = new CreatorSocialAccountEntity(
                        creator,
                        sa.getPlatform(),
                        sa.getProfileUrl()
                );
                creatorSocialAccountRepository.save(account);
            }
        }

        return creator.getId();
    }

    @Transactional(readOnly = true)
    public CreatorResponseDTO getCreator(UUID creatorId) {
        CreatorEntity creator = creatorRepository.findById(creatorId)
                .orElseThrow(() -> new RuntimeException("Creator not found"));

        CreatorProfileEntity profile = creatorProfileRepository.findById(creatorId)
                .orElseThrow(() -> new RuntimeException("Creator profile not found"));

        CreatorGrowthBlueprintEntity growthBlueprint = creatorGrowthBlueprintRepository.findById(creatorId)
                .orElseThrow(() -> new RuntimeException("Creator growth blueprint not found"));

        List<CreatorSocialAccountEntity> socialAccounts = creatorSocialAccountRepository.findByCreatorId(creatorId);
        List<SocialAccountResponseDTO> socialAccountDtos = socialAccounts.stream()
                .map(sa -> new SocialAccountResponseDTO(sa.getPlatform(), sa.getProfileUrl()))
                .collect(Collectors.toList());

        return new CreatorResponseDTO(
                creator.getId(),
                creator.getEmail(),
                creator.getCategory(),
                creator.getNiche(),
                creator.getStage(),
                creator.getAge(),
                profile.getGoals12Months(),
                profile.getDreamOutcome(),
                profile.getBiggestStruggle(),
                profile.getBiggestWin(),
                profile.getTurningPoint(),
                profile.getAdditionalInterests(),
                growthBlueprint.getPriorities(),
                growthBlueprint.getCameraComfort(),
                growthBlueprint.getPostingFrequency(),
                growthBlueprint.getTotalFollowers(),
                socialAccountDtos
        );
    }

    private void validateRequest(IntakeRequestDTO request) {
        if (request == null) {
            throw new IllegalArgumentException("Intake request must not be null");
        }
        if (isBlank(request.getEmail())) {
            throw new IllegalArgumentException("Creator email must not be blank");
        }
        if (isBlank(request.getCategory())) {
            throw new IllegalArgumentException("Creator category must not be blank");
        }
        if (isBlank(request.getNiche())) {
            throw new IllegalArgumentException("Creator niche must not be blank");
        }
        if (isBlank(request.getStage())) {
            throw new IllegalArgumentException("Creator stage must not be blank");
        }
        if (isBlank(request.getGoals12Months())) {
            throw new IllegalArgumentException("Goals 12 months must not be blank");
        }
        if (isBlank(request.getDreamOutcome())) {
            throw new IllegalArgumentException("Dream outcome must not be blank");
        }
        if (isBlank(request.getBiggestStruggle())) {
            throw new IllegalArgumentException("Biggest struggle must not be blank");
        }
        if (isBlank(request.getBiggestWin())) {
            throw new IllegalArgumentException("Biggest win must not be blank");
        }
        if (isBlank(request.getTurningPoint())) {
            throw new IllegalArgumentException("Turning point must not be blank");
        }
        if (request.getPriorities() == null) {
            throw new IllegalArgumentException("Priorities must not be null");
        }
        if (isBlank(request.getCameraComfort())) {
            throw new IllegalArgumentException("Camera comfort must not be blank");
        }
        if (isBlank(request.getPostingFrequency())) {
            throw new IllegalArgumentException("Posting frequency must not be blank");
        }
        if (request.getTotalFollowers() == null) {
            throw new IllegalArgumentException("Total followers must not be null");
        }
    }

    private static boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
}
