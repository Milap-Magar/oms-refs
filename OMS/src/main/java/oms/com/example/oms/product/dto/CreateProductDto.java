package oms.com.example.oms.product.dto;

import oms.com.example.oms.Variant.Variant;
import oms.com.example.oms.category.Category;

public record CreateProductDto(
    long id,
    String title,
    String description,
    Variant variant,
    Category category
) {}
