package oms.com.example.oms.product.dto;

import jakarta.validation.constraints.NotNull;
import oms.com.example.oms.category.Category;
import oms.com.example.oms.category.dto.CategoryResponseDto;
import oms.com.example.oms.variant.Variant;
import oms.com.example.oms.variant.dto.VariantResponseDto;

import java.util.List;

public record ProductResponseDto(
   @NotNull long id,
   String name,
   String description,
   CategoryResponseDto category,
    List<VariantResponseDto> variant
) {}
