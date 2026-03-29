package com.strategyhub.creator.repository;

import com.strategyhub.creator.entity.CreatorSocialAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CreatorSocialAccountRepository extends JpaRepository<CreatorSocialAccountEntity, UUID> {

    @Query("select sa from CreatorSocialAccountEntity sa where sa.creator.id = :creatorId")
    List<CreatorSocialAccountEntity> findByCreatorId(@Param("creatorId") UUID creatorId);
}
