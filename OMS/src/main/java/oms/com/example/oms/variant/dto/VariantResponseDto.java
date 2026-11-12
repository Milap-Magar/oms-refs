package oms.com.example.oms.variant.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import oms.com.example.oms.product.Product;

import java.math.BigDecimal;

public record VariantResponseDto(
        @NotBlank(message = "Variant Id must be given")
        long id,
        long product_id,
        String sku,
        String size,
        String color,
        BigDecimal price
) {}
