package com.amr.project.model.entity;

import com.amr.project.model.enums.Gender;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@ToString(of = {"id", "email", "username", "password", "phone", "firstName", "lastName", "age", "gender"})
@EqualsAndHashCode(of = {"id", "email", "username"})
public class User implements UserDetails {
    //TODO надо продумать юзера, слишком много у него связей,
    // нужны-ли они, возможно где-то вместо связи с ентити использовать id,
    // иначе есть вероятность попасть в констрейнты и не отстроить нормальную структуру
    // для взаимодействия с БД
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private boolean activate;

    @Column
    private String activationCode;

    @Column
    private String phone;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int age;

    @Column
    private Gender gender;

    @Column
    private Calendar birthday;

    @Column
    private boolean isUsingTwoFactorAuth;

    @Column
    private String secret;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JoinColumn(name = "address_id")
    private List<Address> address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JoinColumn(name = "cartItem_id")
    private List<CartItem> cart;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image images;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JoinColumn(name = "coupon_id")
    private List<Coupon> coupons;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JoinColumn(name = "orders_id")
    private List<Order> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JoinColumn(name = "review_id")
    private List<Review> reviews;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JoinColumn(name = "shop_id")
    private List<Shop> shops;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JoinColumn(name = "favorite_id")
    private List<Favorite> favorite;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JoinColumn(name = "discount_id")
    private List<Discount> discounts;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
