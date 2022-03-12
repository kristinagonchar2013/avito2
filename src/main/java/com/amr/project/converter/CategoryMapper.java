package com.amr.project.converter;

import com.amr.project.model.dto.CategoryDto;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Shop;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto categoryToCategoryDto(Category category);
    Category categoryDtoToCategory(CategoryDto categoryDto);
    List<CategoryDto> allCategoryesToCategoryesDto(List<Category> categoryList);
}
