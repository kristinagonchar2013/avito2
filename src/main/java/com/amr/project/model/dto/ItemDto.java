package com.amr.project.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
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
}