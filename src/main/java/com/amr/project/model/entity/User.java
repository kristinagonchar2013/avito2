package com.amr.project.model.entity;

import com.amr.project.model.enums.Gender;
import com.amr.project.model.enums.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "email", "username", "password", "phone", "firstName", "lastName", "age", "gender"})
@EqualsAndHashCode(of = {"id", "email", "username"})
public class User implements UserDetails {
    //TODO надо продумать юзера, слишком много у него связей,
    // нужны-ли они, возможно где-то вместо связи с ентити использовать id,
    // иначе есть вероятность попасть в констрейнты и не отстроить нормальную структуру
    // для взаимодействия с БД
    private Long id;
    private String email;
    private String username;
    private String password;
    private boolean activate;
    private String activationCode;
    private String phone;
    private String firstName;
    private String lastName;
    private int age;
    private List<Address> address;
    private List<Role> roles;
    private Gender gender;
    private Calendar birthday;
    private Image images;
    private List<Coupon> coupons;
    private List<CartItem> cart;
    private List<Order> orders;
    private List<Review> reviews;
    private List<Shop> shops;
    private Favorite favorite;
    private List<Discount> discounts;
    private boolean isUsingTwoFactorAuth;
    private String secret;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles.isEmpty()) {
            return new ArrayList<>();
        } else {
            return roles;
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
