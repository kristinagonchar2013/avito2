package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.jetbrains.annotations.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Comparable<Item>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "base_price")
    private BigDecimal basePrice;
    private BigDecimal price;
    private int count;
    private double rating;
    private String description;
    private int discount;

    @Column(name = "is_moderated")
    private boolean isModerated;

    @Column(name = "moderated_reject_reason")
    private String moderatedRejectReason;

    @Column(name = "is_pretended_to_be_deleted")
    private boolean isPretendedToBeDeleted;

    @Singular
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Category> categories;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private List<Image> images;

    @Singular
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item")
    private List<Review> reviews;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Override
    public int compareTo(@NotNull Item o) {
        return Double.compare(rating, o.rating);
    }
}
