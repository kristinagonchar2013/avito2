package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int count;
    private double rating;
    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
    private boolean isPretendentToBeDeleted;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "shop")
    @JoinColumn(name = "item_id")
    private List<Item> items;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "shop")
    @JoinColumn(name = "review_id")
    private List<Review> reviews;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image logo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private List<Discount> discounts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City location;

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
