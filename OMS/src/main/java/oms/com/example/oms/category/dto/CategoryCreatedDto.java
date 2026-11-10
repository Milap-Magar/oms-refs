package oms.com.example.oms.category.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryCreatedDto(
        @NotNull Long id,
        @NotNull String message
) {
}
