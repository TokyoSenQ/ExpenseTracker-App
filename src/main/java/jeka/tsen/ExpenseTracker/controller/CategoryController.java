package jeka.tsen.ExpenseTracker.controller;

import jakarta.validation.Valid;
import jeka.tsen.ExpenseTracker.dto.Category.CategoryRequestDTO;
import jeka.tsen.ExpenseTracker.dto.Category.CategoryResponseDTO;
import jeka.tsen.ExpenseTracker.dto.Category.CategoryUpdateDTO;
import jeka.tsen.ExpenseTracker.service.Category.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById (@PathVariable UUID id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> addCategory(@Valid @RequestBody CategoryRequestDTO dto) {
        return ResponseEntity.ok(categoryService.addCategory(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(
            @PathVariable UUID id,
            @Valid @RequestBody CategoryUpdateDTO dto) {

        return ResponseEntity.ok(categoryService.updateCategory(id, dto));
    }
}
