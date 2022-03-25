package com.amr.project.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Главная страница")
@Data
public class MainPageDto {
    private List<ShopDto> shopList;
    private List<ItemDto> itemList;
    private List<CategoryDto> categoryList;
    private UserDto user;
}
