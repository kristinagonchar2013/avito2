package com.amr.project.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
public class MainPageDto {

    @Autowired
    private List<ShopDto> shopDtoList;
    private List <ItemDto> itemDtoList;
    private List <CategoryDto> categoryDtoList;
    private UserDto userDto;
}
