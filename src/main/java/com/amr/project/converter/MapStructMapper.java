package com.amr.project.converter;

import com.amr.project.model.dto.*;
import com.amr.project.model.entity.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    ShopDto shopToShopDto(Shop shop);
    Shop shopDtoToShop(ShopDto shopDto);
    List<ShopDto> allShopsToShopsDto(List<Shop> shopList);

    ItemDto itemToItemDto(Item item);
    Item itemDtoToItem(ItemDto itemDto);

    ReviewDto reviewToReviewDto(Review review);
    Review reviewDtoToReview(ReviewDto reviewDto);

    CategoryDto categoryToCategoryDto(Category category);
    Category categoryDtoToCategory(CategoryDto categoryDto);

    DiscountDto discountToDiscountDto(Discount discount);
    Discount discountDtoToDiscount(DiscountDto discountDto);

    CityDto cityToCityDto(City city);
    City cityDtoToCity(CityDto cityDto);

    CountryDto countryToCountryDto(Country country);
    Country countryDtoToCountry(CountryDto countryDto);

    ImageDto imageToImageDto(Image image);
    Image imageDtoToImage(ImageDto imageDto);
}
