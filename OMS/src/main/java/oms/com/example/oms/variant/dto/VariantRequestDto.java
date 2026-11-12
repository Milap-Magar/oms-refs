package oms.com.example.oms.variant.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record VariantRequestDto(
        @NotNull long product_id,
        String sku,
        String size,
        String color,
        BigDecimal price
) {}