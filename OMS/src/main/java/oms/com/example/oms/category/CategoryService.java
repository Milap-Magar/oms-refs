package oms.com.example.oms.category;

import oms.com.example.oms.category.dto.CategoryCreatedDto;
import oms.com.example.oms.category.dto.CategoryRequestDto;
import oms.com.example.oms.category.dto.CategoryResponseDto;
import oms.com.example.oms.category.dto.CategoryUpdateDto;
import oms.com.example.oms.common.exception.CategoryAlreadyExists;
import oms.com.example.oms.common.exception.CategoryNotFound;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Fetch category
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

    // Fetch category by Id
    public CategoryResponseDto fetchCategoryById(long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFound("Category not found"));

        return new CategoryResponseDto(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
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

    // update the values in category
    // by name || description
    public CategoryResponseDto updateCategory(long id, CategoryUpdateDto categoryUpdateDto){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFound("Category not found"));

        if(categoryUpdateDto.name() != null){
            category.setName(categoryUpdateDto.name());
        }
        if(categoryUpdateDto.description() != null){
            category.setDescription(categoryUpdateDto.description());
        }

        Category saved = categoryRepository.save(category);
        return new CategoryResponseDto(
                saved.getId(), saved.getName(), saved.getDescription()
        );
    }

    // delete the data row as a whole
    public void deleteCategory(long id){

        if(!categoryRepository.existsById(id)){
            throw new CategoryNotFound("Category not found");
        }
        categoryRepository.deleteById(id);
    }
}
