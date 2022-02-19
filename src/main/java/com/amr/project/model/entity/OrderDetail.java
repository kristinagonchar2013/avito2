package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@ToString
@EqualsAndHashCode(exclude = "price")
public class OrderDetail {
    //TODO когда будете рисовать БД, подумайте нужен ли этот класс и возможно его лучше совместить с ордером

    @Id
    private Long id;
    @Column
    private BigDecimal total;
    @Column
    private String currency;
    @Column
    private String method;
    @Column
    private String intent;
    @Column
    private String description;
    @Column
    private String country;
    @Column
    private String city;
    @Column
    private String index;
    @Column
    private String street;
    @Column
    private String house;
    @Column
    private String buyerName;
    @Column
    private String buyerPhone;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Order order;



}
