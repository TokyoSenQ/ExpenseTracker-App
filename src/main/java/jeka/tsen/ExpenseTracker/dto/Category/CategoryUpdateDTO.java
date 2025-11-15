package jeka.tsen.ExpenseTracker.dto.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryUpdateDTO {
    @NotBlank(message = "Name is required")
    private String name;
}
