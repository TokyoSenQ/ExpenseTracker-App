package jeka.tsen.ExpenseTracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.UUID;

@Data
public class ExpenseUpdateDTO {

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Amoount is required")
    @Positive(message = "Amount must be positive")
    private Double amount;

    @NotBlank(message = "Date is required")
    private String date;

    @NotNull(message = "Category ID is required")
    private UUID categoryId;


}
