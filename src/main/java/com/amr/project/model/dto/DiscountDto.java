package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Постоянная скидка пользователя")
@Data
@NoArgsConstructor
public class DiscountDto {
    private Long id;
    private int minOrder;
    private int percentage;
    private UserDto user;
    private ShopDto shop;
}
