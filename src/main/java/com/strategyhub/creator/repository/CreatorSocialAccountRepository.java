package com.strategyhub.creator.repository;

import com.strategyhub.creator.entity.CreatorSocialAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreatorSocialAccountRepository extends JpaRepository<CreatorSocialAccountEntity, UUID> {
}
