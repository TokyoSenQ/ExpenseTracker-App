package jeka.tsen.ExpenseTracker.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record ExpenseResponseDTO (
        UUID id,
        String description,
        Double amount,
        LocalDate date,
        String categoryName,
        String userEmail
) {}
