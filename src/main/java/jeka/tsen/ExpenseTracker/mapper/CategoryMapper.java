package jeka.tsen.ExpenseTracker.mapper;

import jeka.tsen.ExpenseTracker.dto.CategoryRequestDTO;
import jeka.tsen.ExpenseTracker.dto.CategoryResponseDTO;
import jeka.tsen.ExpenseTracker.model.Category;

public class CategoryMapper {
    public static Category fromDto(CategoryRequestDTO dto) {
        return Category.builder()
                .name(dto.getName())
                .build();
    }

    public static CategoryResponseDTO toDto(Category category) {
        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
