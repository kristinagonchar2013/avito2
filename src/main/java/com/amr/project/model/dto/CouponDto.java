package com.amr.project.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CouponDto {
    private Long id;
    private int discount;
    private String name;
    private int minOrder;
    private boolean isUsed;
    private UserDto user;
    private ShopDto shop;
}
