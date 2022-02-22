package com.amr.project.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"name", "email", "phone", "location"})
@EqualsAndHashCode(of = {"id", "name"})
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
}