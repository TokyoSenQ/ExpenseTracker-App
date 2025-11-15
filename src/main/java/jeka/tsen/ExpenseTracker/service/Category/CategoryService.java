package jeka.tsen.ExpenseTracker.service.Category;

import jeka.tsen.ExpenseTracker.dto.Category.CategoryRequestDTO;
import jeka.tsen.ExpenseTracker.dto.Category.CategoryResponseDTO;
import jeka.tsen.ExpenseTracker.dto.Category.CategoryUpdateDTO;
import jeka.tsen.ExpenseTracker.exception.ResourceNotFoundException;
import jeka.tsen.ExpenseTracker.mapper.CategoryMapper;
import jeka.tsen.ExpenseTracker.model.Category;
import jeka.tsen.ExpenseTracker.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO getCategoryById(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found: " +id));
        return CategoryMapper.toDto(category);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .toList();
    }

    @Override
    public CategoryResponseDTO addCategory(CategoryRequestDTO dto) {
        Category category = CategoryMapper.fromDto(dto);
        Category saved = categoryRepository.save(category);
        return CategoryMapper.toDto(saved);
    }

    @Override
    public void deleteCategory(UUID id) {
        if(!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found" +id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryResponseDTO updateCategory(UUID id, CategoryUpdateDTO dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found: " + id));

        category.setName(dto.getName());
        Category saved = categoryRepository.save(category);

        return CategoryMapper.toDto(saved);
    }
}
