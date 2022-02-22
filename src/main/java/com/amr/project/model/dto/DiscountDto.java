package com.amr.project.model.dto;

import lombok.Data;

@Data
public class DiscountDto {
    private Long id;
    private int minOrder;
    private int percentage;
}
