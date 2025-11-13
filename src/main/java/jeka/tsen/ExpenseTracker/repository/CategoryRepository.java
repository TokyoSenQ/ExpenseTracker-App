package jeka.tsen.ExpenseTracker.repository;

import jeka.tsen.ExpenseTracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
