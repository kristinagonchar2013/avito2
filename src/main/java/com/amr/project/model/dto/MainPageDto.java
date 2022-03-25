package com.amr.project.model.dto;


import com.amr.project.model.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class MainPageDto {

    private List<ShopDto> shopList;
    private List<ItemDto> itemList;
    private List<CategoryDto> categoryList;
    private User user;
}
