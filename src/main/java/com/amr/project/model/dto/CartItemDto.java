package com.amr.project.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
