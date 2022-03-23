package com.amr.project.model.dto;

import lombok.Data;

@Data
public class CouponDto {

    private Long id;
    private int discount;
    private String name;
    private int minOrder;
    private int percentage;
    private boolean isUsed;
}
