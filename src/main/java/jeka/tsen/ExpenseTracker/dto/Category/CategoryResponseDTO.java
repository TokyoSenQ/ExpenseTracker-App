package jeka.tsen.ExpenseTracker.dto.Category;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CategoryResponseDTO(
    UUID id,
    String name
) { }
