package com.amr.project.converter;

import com.amr.project.model.dto.*;
import com.amr.project.model.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    ShopDto shopToShopDto(Shop shop);
    Shop shopDtoToShop(ShopDto shopDto);

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

    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);

    Address addressDtoToAddress(AddressDto addressDto);
    AddressDto addressToAddress(Address address);

    CartItem cartItemDtoToCarItem(CartItemDto cartItemDto);
    CartItemDto cartItemToCarItemDto(CartItem cartItem);

    Coupon couponDtoToCoupon(CouponDto couponDto);
    CouponDto couponToCouponDto(Coupon coupon);

    Favorite favoriteDtoToFavorite(FavoriteDto favoriteDto);
    FavoriteDto favoriteToFavoriteDto(Favorite favorite);

    OrderDetail orderDetailDtoToOrderDetail(OrderDetailDto orderDetailDto);
    OrderDetailDto orderDetailToOrderDetailDto(OrderDetail orderDetail);

    Order orderDtoToOrder(OrderDto orderDto);
    OrderDto orderToOrderDto(Order order);




}
