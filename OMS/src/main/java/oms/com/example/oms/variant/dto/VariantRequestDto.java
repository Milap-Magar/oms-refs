package oms.com.example.oms.variant.dto;

import java.math.BigDecimal;

public record VariantRequestDto(
        String sku,
        String size,
        String color,
        BigDecimal price
) {}