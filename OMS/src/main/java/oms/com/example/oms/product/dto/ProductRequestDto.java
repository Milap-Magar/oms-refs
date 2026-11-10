package oms.com.example.oms.product.dto;

import oms.com.example.oms.category.Category;
import oms.com.example.oms.variant.dto.VariantRequestDto;

import java.util.List;

public record ProductRequestDto(
   String name,
   String description,
   Category category,
   List<VariantRequestDto> variants
) {}
