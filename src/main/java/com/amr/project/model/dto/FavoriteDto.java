package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "Избранное пользователя (магазины и товары)")
@Data
@NoArgsConstructor
public class FavoriteDto {
    private Long id;
    private List<ItemDto> items;
    private List<ShopDto> shops;
    private UserDto user;
}
