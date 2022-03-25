package com.amr.project.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Товары находящиеся в корзине")
@Data
@NoArgsConstructor
public class CartItemDto {
    private Long id;
    private String anonID;
    private BigDecimal totalPrice;
    private int quantity;
    private UserDto user;
    private ItemDto item;
}
