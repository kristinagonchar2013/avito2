package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "shop")
@Data
@Builder
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
    private boolean isModerated = false;
    private boolean isModerateAccept = false;
    private String moderatedRejectReason;
    private boolean isPretendentToBeDeleted = false;

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
    @JoinColumn(name = "country_id")
    private Country location;


    public Shop() {

    }
}
