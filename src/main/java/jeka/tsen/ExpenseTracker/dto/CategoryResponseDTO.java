package jeka.tsen.ExpenseTracker.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CategoryResponseDTO(
    UUID id,
    String name
) { }
