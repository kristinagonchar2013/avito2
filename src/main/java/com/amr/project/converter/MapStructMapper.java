package com.amr.project.converter;

import com.amr.project.model.dto.*;
import com.amr.project.model.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    ShopDto ShopToShopDto(Shop shop);
    Shop ShopDtoToShop(ShopDto shopDto);

    ItemDto ItemToItemDto(Item item);
    Item ItemDtoToItem(ItemDto itemDto);

    ReviewDto ReviewToReviewDto(Review review);
    Review ReviewDtoToReview(ReviewDto reviewDto);

    CategoryDto CategoryToCategoryDto(Category category);
    Category CategoryDtoToCategory(CategoryDto categoryDto);

    DiscountDto DiscountToDiscountDto(Discount discount);
    Discount DiscountDtoToDiscount(DiscountDto discountDto);

    CityDto CityToCityDto(City city);
    City CityDtoToCity(CityDto cityDto);

    CountryDto CountryToCountryDto(Country country);
    Country CountryDtoToCountry(CountryDto countryDto);

    ImageDto ImageToImageDto(Image image);
    Image ImageDtoToImage(ImageDto imageDto);
}
