package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "item")
@Data
@Builder
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
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
    @Column
    private boolean isModerated = false;
    @Column
    private String moderatedRejectReason;
    @Column
    private boolean isPretendedToBeDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private List<Image> images;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
    @JoinColumn(name = "review_id")
    private List<Review> reviews;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;
}
