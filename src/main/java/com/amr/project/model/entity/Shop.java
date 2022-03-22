package com.amr.project.model.entity;

import com.amr.project.model.enums.EstablishedStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "shop")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String description;
    private double rating;

    @Column(name = "is_moderated")
    private boolean isModerated;

    @Column(name = "is_moderate_accept")
    private boolean isModerateAccept;

    @Column(name = "moderated_reject_reason")
    private String moderatedRejectReason;

    @Column(name = "is_pretendent_be_deleted")
    private boolean isPretendentToBeDeleted;
    private EstablishedStatus establishedStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id")
    private City location;

    @Singular
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
    private List<Item> items;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "shop")
    private List<Review> reviews;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image logo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE, mappedBy = "shop")
    private List<Discount> discounts;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "shop")
    private List<Coupon> coupons;

    public void addItemToShop(Item item) {
        if (items == null) {
            items = new LinkedList<>();
        }
        this.items.add(item);
    }

    public void deleteItemFromShop(Item item) {
        if (items != null) {
            items.remove(item);
        }
    }

    public void addReviewToShop(Review review) {
        if (review == null) {
            reviews = new LinkedList<>();
        }
        this.reviews.add(review);
    }

    public void deleteReviewFromShop(Review review) {
        if (reviews != null) {
            reviews.remove(review);
        }
    }

    public void addDiscountToShop(Discount discount) {
        if (discount == null) {
            discounts = new LinkedList<>();
        }
        discounts.add(discount);
    }

    public void deleteDiscountFromShop(Discount discount) {
        if (discounts != null) {
            discounts.remove(discount);
        }
    }
}
