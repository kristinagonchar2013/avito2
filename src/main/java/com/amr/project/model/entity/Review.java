package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "review")
@Data
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dignity;

    @Column
    private String flaw;

    @Column
    private String text;

    @Column
    private Date date;

    @Column
    private int rating;

    @Column(name = "is_moderated")
    private boolean isModerated = false;

    @Column(name = "is_moderate_accept")
    private boolean isModerateAccept = false;

    @Column(name = "moderate_reject_reason")
    private String moderatedRejectReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Review() {

    }
}
