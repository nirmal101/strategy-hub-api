package com.strategyhub.creator.repository;

import com.strategyhub.creator.entity.CreatorGrowthBlueprintEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreatorGrowthBlueprintRepository extends JpaRepository<CreatorGrowthBlueprintEntity, UUID> {
}
