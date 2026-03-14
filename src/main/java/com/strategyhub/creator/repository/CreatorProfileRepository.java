package com.strategyhub.creator.repository;

import com.strategyhub.creator.entity.CreatorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreatorProfileRepository extends JpaRepository<CreatorProfile, UUID> {
}
