package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Товар")
@Data
@NoArgsConstructor
public class ItemDto {
    private Long id;
    private String name;
    private BigDecimal basePrice;
    private BigDecimal price;
    private double rating;
    private String description;
    private int discount;
    private CategoryDto category;
    private List<ImageDto> images;
    private List<ReviewDto> reviews;
    private ShopDto shop;
    private String status;
}