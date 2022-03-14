package com.amr.project.converter;

import com.amr.project.model.dto.MainPageDto;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MainPageMapper {

    MainPageDto searchToMainPageDto(List<Shop> shopList, List<Item> itemList);
}
