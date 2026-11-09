package oms.com.example.oms.category;

import jakarta.validation.Valid;
import oms.com.example.oms.category.dto.*;
import oms.com.example.oms.common.exception.CategoryRequired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    // get category all
    @GetMapping
    public List<CategoryResponseDto> category() {
        return categoryService.fetchCategory();
    }

    // get category by id
    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable long id
    ){
        return categoryService.fetchCategoryById(id);
    }

    // Create category
    @PostMapping
    public ResponseEntity<CategoryCreatedDto> category(
            @Valid @RequestBody CategoryRequestDto request
    ){
        CategoryCreatedDto response = categoryService.createCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    };

    // Update category
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> categoryUpdate(
            @PathVariable long id,
            @Valid @RequestBody CategoryUpdateDto categoryUpdateDto
    ) {
        if(categoryUpdateDto == null){
            throw new CategoryRequired("Category name is Required");
        }

        CategoryResponseDto response = categoryService.updateCategory(id, categoryUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    };

    // Delete category by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> categoryDelete(
            @PathVariable long id
    ){
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).body("Category " + id + "deleted");
    }

}
