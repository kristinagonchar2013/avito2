package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "discount")
@Data
@Builder
public class Discount {
    //TODO скидка для постоянного покупателя
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int minOrder;
    @Column
    private int percentage;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Discount() {

    }
}
