package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Schema(description = "Магазин")
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"name", "email", "phone", "location"})
@EqualsAndHashCode(of = {"id", "name", "email"})
public class ShopDto {

    private Long id;
    private String name;
    private String description;
    private String email;
    private String phone;
    private double rating;
    private List<ItemDto> items;
    private List<ReviewDto> reviews;
    private ImageDto logo;
    private List<DiscountDto> discounts;
    private CityDto location;
    private String status;
}