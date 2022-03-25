package com.amr.project.converter;

import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto itemToItemDto(Item item);

    Item itemDtoToItem(ItemDto itemDto);

    List<ItemDto> allItemsToItemsDto(List<Item> itemList);
}
