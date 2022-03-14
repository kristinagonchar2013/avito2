package com.amr.project.model.dto;

import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;

import java.util.List;

public class MainPageDto {

    private List<ShopDto> shopList;
    private List<ItemDto> itemList;
    private List<CategoryDto> categoryList;
    private User user;
}
