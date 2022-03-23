package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Одноразовые купоны")
@Data
@NoArgsConstructor
public class CouponDto {

    private Long id;
    private int discount;
    private String name;
    private int minOrder;
    private int percentage;
    private boolean isUsed;
}
