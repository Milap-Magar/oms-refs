package oms.com.example.oms.variant.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record VariantResponseDto(
        @NotNull long id,
        String sku,
        String size,
        String color,
        BigDecimal price
) {}
