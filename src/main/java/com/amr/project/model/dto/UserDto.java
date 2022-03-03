package com.amr.project.model.dto;


import com.amr.project.model.enums.Gender;
import java.util.Calendar;
import java.util.List;

public class UserDto {
    private Long id;
    private String email;
    private String username;
    private String phone;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private Calendar birthday;
    private List<AddressDto> address;
    private List<CartItemDto> cart;
    private ImageDto images;
    private List<CouponDto> coupons;
    private List<OrderDto> orders;
    private List<ShopDto> shops;
    private List<FavoriteDto> favorite;
    private List<DiscountDto> discounts;
}
