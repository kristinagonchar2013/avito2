package com.amr.project.model.entity;

import com.amr.project.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Enumerated(EnumType.STRING) //статус будет в виде стринг
    private Status status;
    private BigDecimal total;
    private String buyerName;
    private String buyerPhone;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)  //добавила каскад
    @JoinColumn(name = "item_id") //связь однонаправленная, оставляем как есть
    private List<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order") //добавила каскад
    private OrderDetail orderDetail; //при правильной связи - это поле можно удалить, айди будут одинаковые
}
