package jeka.tsen.ExpenseTracker.service.Category;

import jeka.tsen.ExpenseTracker.dto.Category.CategoryRequestDTO;
import jeka.tsen.ExpenseTracker.dto.Category.CategoryResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    CategoryResponseDTO getCategoryById(UUID id);
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO addCategory(CategoryRequestDTO dto);
    void deleteCategory(UUID id);
}
