package oms.com.example.oms.category;

import jakarta.validation.Valid;
import oms.com.example.oms.category.dto.CategoryCreatedDto;
import oms.com.example.oms.category.dto.CategoryRequestDto;
import oms.com.example.oms.category.dto.CategoryResponseDto;
import oms.com.example.oms.category.dto.CategoryUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
            @Valid @PathVariable long id,
            @RequestBody CategoryUpdateDto categoryUpdateDto
    ) throws Exception {
        if(categoryUpdateDto.name() == null){
            throw new Exception("Category name is Required");
        }
        if(categoryUpdateDto.description() == null){
            throw new Exception("Category description is Required");
        }

        CategoryResponseDto response = categoryService.updateCategory(id, categoryUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    };
}
