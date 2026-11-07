package oms.com.example.oms.category;

import oms.com.example.oms.category.dto.CategoryCreatedDto;
import oms.com.example.oms.category.dto.CategoryRequestDto;
import oms.com.example.oms.category.dto.CategoryResponseDto;
import oms.com.example.oms.common.exception.CategoryAlreadyExists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Fetch category [[GET]]
    public List<CategoryResponseDto> fetchCategory() {
        // Retrieves and returns a list of all department entities.
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDto> result = new ArrayList<>();
        for(Category c : categories){
            result.add(new CategoryResponseDto(
                    c.getId(), c.getName(), c.getDescription()
            ));
        }
        return result;
    }


    // Create category handling [[POST]]
    public CategoryCreatedDto createCategory(CategoryRequestDto request) {
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
        return new CategoryCreatedDto(saved.getId(), "Category Created");
    }
}
