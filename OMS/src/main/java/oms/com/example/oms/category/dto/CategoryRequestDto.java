package oms.com.example.oms.category.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryRequestDto(
        @NotNull String name,
        @NotNull String description
){};
