package oms.com.example.oms.category.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryUpdateDto(
    String name,
    String description
) {}
