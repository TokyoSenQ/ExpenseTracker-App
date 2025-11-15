package jeka.tsen.ExpenseTracker.dto.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequestDTO {
    @NotBlank
    private String name;
}
