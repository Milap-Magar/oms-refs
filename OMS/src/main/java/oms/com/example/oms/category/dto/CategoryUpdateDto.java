package oms.com.example.oms.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryUpdateDto(
    @NotBlank(message = "Category Name is required")
    @Size(max=100, message = "Category cannot exceed 100 characters")
    String name,

    @Size(max=500, message = "Category Description cannot exceed 500 characters")
    String description
) {}
