package com.amr.project.converter;

import com.amr.project.model.dto.MainPageDto;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.MainPage;
import com.amr.project.model.entity.Shop;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MainPageMapper {

    MainPageDto mainPageToMainPageDto(List<Shop> shopList, List<Item> itemList);
    MainPage mainPageDtoToMainPage(MainPageDto mainPageDto);

}

