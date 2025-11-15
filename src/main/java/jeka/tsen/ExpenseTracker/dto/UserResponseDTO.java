package jeka.tsen.ExpenseTracker.dto;

import jeka.tsen.ExpenseTracker.model.Expense;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record UserResponseDTO(
        UUID id,
        String email,
        String name
) {}
