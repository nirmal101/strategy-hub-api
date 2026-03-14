package com.strategyhub.creator.repository;

import com.strategyhub.creator.entity.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreatorRepository extends JpaRepository<Creator, UUID> {
}
