package com.amr.project.model.entity;

import com.amr.project.model.enums.Gender;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Data
//@Builder
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="user")
    @JoinColumn(name = "address_id")
    private List<Address> address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy ="user")
    @JoinColumn(name = "cartItem_id")
    private List<CartItem> cart;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image images;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    @JoinColumn(name = "coupon_id")
    private List<Coupon> coupons;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    @JoinColumn(name = "orders_id")
    private List<Order> orders;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    @JoinColumn(name = "review_id")
    private List<Review> reviews;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    @JoinColumn(name = "shop_id")
    private List<Shop> shops;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    @JoinColumn(name = "favorite_id")
    private List<Favorite> favorite;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    @JoinColumn(name = "discount_id")
    private List<Discount> discounts;

    public User(Long id, String email, String username, String password, boolean activate, String activationCode,
                String phone, String firstName, String lastName, int age, Gender gender, Calendar birthday,
                boolean isUsingTwoFactorAuth, String secret, List<Address> address, List<CartItem> cart,
                Image images, List<Coupon> coupons, List<Order> orders, List<Review> reviews, List<Shop> shops,
                List<Favorite> favorite, List<Discount> discounts) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.activate = activate;
        this.activationCode = activationCode;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.isUsingTwoFactorAuth = isUsingTwoFactorAuth;
        this.secret = secret;
        this.address = address;
        this.cart = cart;
        this.images = images;
        this.coupons = coupons;
        this.orders = orders;
        this.reviews = reviews;
        this.shops = shops;
        this.favorite = favorite;
        this.discounts = discounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public boolean isUsingTwoFactorAuth() {
        return isUsingTwoFactorAuth;
    }

    public void setUsingTwoFactorAuth(boolean usingTwoFactorAuth) {
        isUsingTwoFactorAuth = usingTwoFactorAuth;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public void setCart(List<CartItem> cart) {
        this.cart = cart;
    }

    public Image getImages() {
        return images;
    }

    public void setImages(Image images) {
        this.images = images;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public List<Favorite> getFavorite() {
        return favorite;
    }

    public void setFavorite(List<Favorite> favorite) {
        this.favorite = favorite;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

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
