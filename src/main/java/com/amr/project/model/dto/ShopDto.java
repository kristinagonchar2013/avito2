package com.amr.project.model.dto;

import com.amr.project.model.enums.EstablishedStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
    private boolean isPretendentToBeDeleted;
    private EstablishedStatus establishedStatus;
    private List<ItemDto> items;
    private List<ReviewDto> reviews;
    private ImageDto logo;
    private List<DiscountDto> discounts;
    private CityDto location;
    private UserDto user;
    private List<CouponDto> coupons;
}