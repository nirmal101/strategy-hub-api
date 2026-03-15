package com.strategyhub.creator.repository;

import com.strategyhub.creator.entity.CreatorProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreatorProfileRepository extends JpaRepository<CreatorProfileEntity, UUID> {
}
