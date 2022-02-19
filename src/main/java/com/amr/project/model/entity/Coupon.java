package com.amr.project.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "coupon")
@Data
public class Coupon {
    //TODO разовый скидочный купон для покупателя, добавить поля
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
