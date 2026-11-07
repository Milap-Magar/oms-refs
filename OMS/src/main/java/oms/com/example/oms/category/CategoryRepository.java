package oms.com.example.oms.category;

import oms.com.example.oms.category.dto.CategoryRequestDto;
import oms.com.example.oms.category.dto.CategoryResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // creating a new category
    boolean existsByName(String name);
}
