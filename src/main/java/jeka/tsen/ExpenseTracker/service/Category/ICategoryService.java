package jeka.tsen.ExpenseTracker.service.Category;

import jeka.tsen.ExpenseTracker.dto.CategoryRequestDTO;
import jeka.tsen.ExpenseTracker.dto.CategoryResponseDTO;
import jeka.tsen.ExpenseTracker.model.Expense;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    CategoryResponseDTO getCategoryById(UUID id);
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO addCategory(CategoryRequestDTO dto);
    void deleteCategory(UUID id);
}
