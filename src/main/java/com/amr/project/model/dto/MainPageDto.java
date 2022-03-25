package com.amr.project.model.dto;

import com.amr.project.model.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Главная страница")
@Data
public class MainPageDto {

    private List<ShopDto> shopList;
    private List<ItemDto> itemList;
    private List<CategoryDto> categoryList;
    private User user;
}
