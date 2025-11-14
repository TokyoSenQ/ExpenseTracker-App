package jeka.tsen.ExpenseTracker.service.Expense;

import jeka.tsen.ExpenseTracker.dto.ExpenseRequestDTO;
import jeka.tsen.ExpenseTracker.dto.ExpenseResponseDTO;
import jeka.tsen.ExpenseTracker.model.Expense;

import java.util.List;
import java.util.UUID;

public interface IExpenseService {
    List<ExpenseResponseDTO> getAllExpenses();
    ExpenseResponseDTO addExpense(ExpenseRequestDTO dto);
    void deleteExpense(UUID id);
    ExpenseResponseDTO getExpenseDtoById(UUID id);
}
