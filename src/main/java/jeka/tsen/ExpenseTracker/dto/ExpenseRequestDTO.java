package jeka.tsen.ExpenseTracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.UUID;

@Data
public class ExpenseRequestDTO {

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private Double amount;

    @NotBlank(message = "Date is required")
    private String date;

    @NotNull(message = "User ID is required")
    private UUID userId;

    @NotNull(message = "Category ID is required")
    private UUID categoryId;
}
