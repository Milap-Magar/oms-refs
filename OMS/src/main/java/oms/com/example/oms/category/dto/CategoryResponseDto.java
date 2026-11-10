package oms.com.example.oms.category.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryResponseDto (
        @NotNull long id,
        @NotNull String name,
        @NotNull String description
){};
