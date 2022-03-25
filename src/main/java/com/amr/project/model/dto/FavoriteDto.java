package com.amr.project.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FavoriteDto {
    private Long id;
    private List<ItemDto> items;
    private List<ShopDto> shops;
    private UserDto user;
}
