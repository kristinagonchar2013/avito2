package com.amr.project.model.dto;

import com.amr.project.model.enums.Gender;
import com.amr.project.model.enums.Role;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String username;
    private boolean activate;
    private String phone;
    private String firstName;
    private String lastName;
    private Role role;
    private String password;
    private int age;
    private Gender gender;
    private Calendar birthday;
    private boolean isUsingTwoFactorAuth;
    private String secret;
    private List<AddressDto> addresses;
    private List<CartItemDto> cart;
    private ImageDto image;
    private List<CouponDto> coupons;
    private List<OrderDto> orders;
    private List<ReviewDto> reviews;
    private List<ShopDto> shops;
    private FavoriteDto favorite;
    private List<DiscountDto> discounts;
    private Set<ChatDto> chats;
}
