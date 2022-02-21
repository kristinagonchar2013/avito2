package com.amr.project.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DiscountDto {
    private Long id;
    private int minOrder;
    private int percentage;
}
