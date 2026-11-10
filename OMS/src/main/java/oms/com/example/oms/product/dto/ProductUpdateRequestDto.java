package oms.com.example.oms.product.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductUpdateRequestDto(
        @NotNull @Positive BigDecimal price
){}
