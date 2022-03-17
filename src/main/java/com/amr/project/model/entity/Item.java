package com.amr.project.model.entity;

import com.amr.project.model.enums.EstablishedStatus;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal basePrice;
    private BigDecimal price;
    private int count;
    private double rating;
    private String description;
    private int discount;
    private boolean isModerated;
    private String moderatedRejectReason;
    private boolean isPretendedToBeDeleted;
    private EstablishedStatus establishedStatus;

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
