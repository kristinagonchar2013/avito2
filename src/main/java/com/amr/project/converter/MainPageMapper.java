package com.amr.project.converter;

import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.dto.MainPageDto;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MainPageMapper {

    default MainPageDto mainPageToMainPageDto(List<Shop> shops, List<Item> items) {
        MainPageDto mainPageDto = new MainPageDto();
        mainPageDto.setItemList(itemsToItemDtos(items));
        mainPageDto.setShopList(shopsToShopDtos(shops));
        return mainPageDto;
    }

    List<ShopDto> shopsToShopDtos(List<Shop> shopList);

    List<ItemDto> itemsToItemDtos(List<Item> items);
    MainPageDto mainPageToMainPageDto(List<Shop> shopList, List<Item> itemList);
    MainPageDto mainPageToMainPageDtoHead(List<Shop> shopList, List<Item> itemList, List<Category> categoryList, User user);
}

