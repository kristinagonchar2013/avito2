package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
@Data
@Builder
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String description;
    @Column
    private int count;
    @Column
    private double rating;
    @Column
    private boolean isModerated = false;
    @Column
    private boolean isModerateAccept = false;
    @Column
    private String moderatedRejectReason;
    @Column
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
