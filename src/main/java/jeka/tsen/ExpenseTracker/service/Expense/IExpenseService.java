package jeka.tsen.ExpenseTracker.service.Expense;

import jeka.tsen.ExpenseTracker.dto.Expenses.ExpenseRequestDTO;
import jeka.tsen.ExpenseTracker.dto.Expenses.ExpenseResponseDTO;
import jeka.tsen.ExpenseTracker.dto.Expenses.ExpenseUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface IExpenseService {
    List<ExpenseResponseDTO> getAllExpenses();
    ExpenseResponseDTO addExpense(ExpenseRequestDTO dto);
    void deleteExpense(UUID id);
    ExpenseResponseDTO getExpenseDtoById(UUID id);
    ExpenseResponseDTO updateExpense(UUID id, ExpenseUpdateDTO updateDTO);
}
