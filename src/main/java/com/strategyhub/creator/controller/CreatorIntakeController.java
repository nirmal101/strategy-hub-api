package com.strategyhub.creator.controller;

import com.strategyhub.creator.dto.CreatorIntakeResponseDTO;
import com.strategyhub.creator.dto.CreatorResponseDTO;
import com.strategyhub.creator.dto.IntakeRequestDTO;
import com.strategyhub.creator.service.CreatorIntakeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/creators")
public class CreatorIntakeController {

    private final CreatorIntakeService creatorIntakeService;

    public CreatorIntakeController(CreatorIntakeService creatorIntakeService) {
        this.creatorIntakeService = creatorIntakeService;
    }

    @PostMapping("/intake")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatorIntakeResponseDTO intake(@Valid @RequestBody IntakeRequestDTO request) {
        var creatorId = creatorIntakeService.createCreator(request);
        return new CreatorIntakeResponseDTO(creatorId);
    }

    @GetMapping("/{creatorId}")
    public CreatorResponseDTO getCreator(@PathVariable UUID creatorId) {
        return creatorIntakeService.getCreator(creatorId);
    }
}
