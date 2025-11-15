package jeka.tsen.ExpenseTracker.mapper;

import jeka.tsen.ExpenseTracker.dto.Expenses.ExpenseRequestDTO;
import jeka.tsen.ExpenseTracker.dto.Expenses.ExpenseResponseDTO;
import jeka.tsen.ExpenseTracker.model.Expense;

import java.time.LocalDate;

public class ExpenseMapper {

    public static Expense fromDto(ExpenseRequestDTO dto) {
        return Expense.builder()
                .description(dto.getDescription())
                .amount(dto.getAmount())
                .date(LocalDate.parse(dto.getDate()))
                .build();
    }

    public static ExpenseResponseDTO toDto(Expense expense) {
        return ExpenseResponseDTO.builder()
                .id(expense.getId())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .date(expense.getDate())
                .categoryName(expense.getCategory() != null ? expense.getCategory().getName() : null)
                .userEmail(expense.getUser() != null ? expense.getUser().getEmail() : null)
                .build();
    }



}
