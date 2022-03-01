package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "shop")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String description;
    private City location;
    private List<Item> items;
    private List<Review> reviews;
    private Image logo;
    private int count;
    private double rating;
    private User user;
    private List<Discount> discounts;
    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
    private boolean isPretendentToBeDeleted;

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
