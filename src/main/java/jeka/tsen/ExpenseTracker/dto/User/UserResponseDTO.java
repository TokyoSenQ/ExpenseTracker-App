package jeka.tsen.ExpenseTracker.dto.User;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponseDTO(
        UUID id,
        String email,
        String name
) {}
