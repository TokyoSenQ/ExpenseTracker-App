package jeka.tsen.ExpenseTracker.service.Expense;


import jeka.tsen.ExpenseTracker.dto.ExpenseRequestDTO;
import jeka.tsen.ExpenseTracker.dto.ExpenseResponseDTO;
import jeka.tsen.ExpenseTracker.dto.ExpenseUpdateDTO;
import jeka.tsen.ExpenseTracker.exception.ResourceNotFoundException;
import jeka.tsen.ExpenseTracker.mapper.ExpenseMapper;
import jeka.tsen.ExpenseTracker.model.Category;
import jeka.tsen.ExpenseTracker.model.Expense;
import jeka.tsen.ExpenseTracker.model.User;
import jeka.tsen.ExpenseTracker.repository.CategoryRepository;
import jeka.tsen.ExpenseTracker.repository.ExpenseRepository;
import jeka.tsen.ExpenseTracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpenseService implements IExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public ExpenseResponseDTO getExpenseDtoById(UUID id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found" +id));

        return ExpenseMapper.toDto(expense);
    }

    @Override
    public ExpenseResponseDTO updateExpense(UUID id, ExpenseUpdateDTO dto) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found: " + id));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found: " + dto.getCategoryId()));

        expense.setDescription(dto.getDescription());
        expense.setAmount(dto.getAmount());
        expense.setDate(java.time.LocalDate.parse(dto.getDate()));
        expense.setCategory(category);

        Expense saved = expenseRepository.save(expense);
        return ExpenseMapper.toDto(saved);
    }

    @Override
    public List<ExpenseResponseDTO> getAllExpenses() {
        return expenseRepository.findAll()
                .stream()
                .map(ExpenseMapper::toDto)
                .toList();
    }

    @Override
    public ExpenseResponseDTO addExpense(ExpenseRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found" +dto.getUserId()));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found" +dto.getCategoryId()));

        Expense expense = ExpenseMapper.fromDto(dto);
        expense.setUser(user);
        expense.setCategory(category);

        Expense saved = expenseRepository.save(expense);

        return ExpenseMapper.toDto(saved);
    }

    @Override
    public void deleteExpense(UUID id) {
        expenseRepository.deleteById(id);
    }


}
