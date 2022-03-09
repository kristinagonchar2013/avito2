package com.amr.project.model.entity;

import com.amr.project.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Calendar date;
    @Enumerated(EnumType.STRING)
    private Status status;
    private BigDecimal total;
//    private String buyerName;
//    private String buyerPhone;

    @Singular
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "item_id")
    private List<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
//    private OrderDetail orderDetail;
//    private Long orderDetailId;
}
