package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "item")
@Data
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "base_price")
    private BigDecimal basePrice;

    @Column
    private BigDecimal price;

    @Column
    private int count;

    @Column
    private double rating;

    @Column
    private String description;

    @Column
    private int discount;

    @Column(name = "is_moderated")
    private boolean isModerated = false;

    @Column(name = "moderated_reject_reason")
    private String moderatedRejectReason;

    @Column(name = "is_pretended_to_be_deleted")
    private boolean isPretendedToBeDeleted;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Set<Category> categories;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private List<Image> images;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item")
    @JoinColumn(name = "review_id")
    private List<Review> reviews;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Item() {

    }
}
