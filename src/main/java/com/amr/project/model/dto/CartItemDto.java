package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Товары находящиеся в корзине")
@Data
@NoArgsConstructor
public class CartItemDto {

    private Long id;
    private String anonID;
    private int quantity;
    private OrderDto order;
    private UserDto user;
    private ItemDto item;
}
