package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import com.amr.project.model.enums.EstablishedStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Schema(description = "Товар")
@Data
@NoArgsConstructor
public class ItemDto {
    private Long id;
    private String name;
    private BigDecimal basePrice;
    private BigDecimal price;
    private int count;
    private double rating;
    private String description;
    private int discount;
    private boolean isModerated;
    private String moderatedRejectReason;
    private boolean isPretendedToBeDeleted;
    private EstablishedStatus establishedStatus;
    private Set<CategoryDto> categories;
    private List<ImageDto> images;
    private List<ReviewDto> reviews;
    private ShopDto shop;
}