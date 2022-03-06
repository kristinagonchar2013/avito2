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
public class OrderDetail {
    @Id
    private Long id;
    private BigDecimal total;
    private String currency;
    private String method;
    private String intent;
    private String description;
    private String country;
    private String city;
    private String index;
    private String street;
    private String house;
    private String buyerName;
    private String buyerPhone;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Order order;

}
