package com.amr.project.model.entity;

import com.amr.project.model.enums.Gender;
import com.amr.project.model.enums.Role;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@ToString(of = {"id", "email", "username", "password", "phone", "firstName", "lastName", "age", "gender"})
@EqualsAndHashCode(of = {"id", "email", "username"})
public class User implements UserDetails {
    //TODO надо продумать юзера, слишком много у него связей,
    // нужны-ли они, возможно где-то вместо связи с ентити использовать id,
    // иначе есть вероятность попасть в констрейнты и не отстроить нормальную структуру
    // для взаимодействия с БД
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany
    private List<Address> address;

    @Column
    private Role roles;

    @Column
    private Gender gender;

    @Column
    private Calendar birthday;

    @OneToOne
    private Image images;

    @OneToMany
    private List<Coupon> coupons;

    @OneToMany
    private List<CartItem> cart;

    @OneToMany
    private List<Order> orders;

    @OneToMany
    private List<Review> reviews;

    @OneToMany
    private List<Shop> shops;

    @OneToOne
    private Favorite favorite;

    @OneToMany
    private List<Discount> discounts;

    @Column
    private boolean isUsingTwoFactorAuth;

    @Column
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
