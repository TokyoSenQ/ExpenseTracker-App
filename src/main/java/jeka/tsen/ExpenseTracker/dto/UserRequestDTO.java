package jeka.tsen.ExpenseTracker.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {
    @NotBlank(message = "Name is required")
    String name;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    String email;
}
