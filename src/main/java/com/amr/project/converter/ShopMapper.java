package com.amr.project.converter;

import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShopMapper {

    ShopDto shopToShopDto(Shop shop);
    Shop shopDtoToShop(ShopDto shopDto);
    List<ShopDto> allShopsToShopsDto(List<Shop> shopList);
}
