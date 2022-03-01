package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Coupon {
    private Long id;
    private int discount;
    private int minOrder;
    private String name;
    private User user;
    private Shop shop;
    private boolean isUsed;
}
