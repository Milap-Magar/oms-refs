package oms.com.example.oms.category;

import oms.com.example.oms.category.dto.CategoryRequestDto;
import oms.com.example.oms.category.dto.CategoryResponseDto;
import oms.com.example.oms.common.exception.CategoryAlreadyExists;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Create category handling [[POST]]
    public CategoryResponseDto createCategory(CategoryRequestDto request) {
        if (categoryRepository.existsByName(request.name())) {
            throw new CategoryAlreadyExists("Category already exists!");
        }

        // DTO -> entity (id is left empty; Postgres generates it)
        Category category = new Category();
        category.setName(request.name());
        category.setDescription(request.description());

        // save() returns the stored entity with its generated id
        Category saved = categoryRepository.save(category);

        // entity -> response DTO
        return new CategoryResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getDescription()
        );
    }
}
