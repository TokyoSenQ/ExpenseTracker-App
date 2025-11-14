package jeka.tsen.ExpenseTracker.controller;

import jakarta.validation.Valid;
import jeka.tsen.ExpenseTracker.dto.ExpenseRequestDTO;
import jeka.tsen.ExpenseTracker.dto.ExpenseResponseDTO;
import jeka.tsen.ExpenseTracker.service.Expense.IExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/expenses")
@Validated
public class ExpenseController {

    private final IExpenseService expenseService;

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseDTO> getExpenseById (@PathVariable UUID id){
        return ResponseEntity.ok(expenseService.getExpenseDtoById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ExpenseResponseDTO>> getAllExpenses () {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @PostMapping
    public ResponseEntity<ExpenseResponseDTO> addExpense (@Valid @RequestBody ExpenseRequestDTO dto) {
        ExpenseResponseDTO saved = expenseService.addExpense(dto);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable UUID id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

}
