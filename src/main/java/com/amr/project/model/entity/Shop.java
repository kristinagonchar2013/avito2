package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String description;
    private int count; //TODO что это за поле?
    private double rating;

    @Column(name = "is_moderated")
    private boolean isModerated = false;

    @Column(name = "is_moderate_accept")
    private boolean isModerateAccept = false;

    @Column(name = "moderated_reject_reason")
    private String moderatedRejectReason;

    @Column(name = "is_pretendent_be_deleted")
    private boolean isPretendentToBeDeleted = false;

    //TODO у магазина должен быть адрес по условию Adress. Зачем здесь город?
    // может сделать двунаправленную связь ManyToOne?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id") //добавила joinColumn и manyToMany //TODO где ManyToMany?
    private City location;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop") //добавила аннотацию
    private List<Item> items;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "shop")
    private List<Review> reviews;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image logo;

    @ManyToOne(fetch = FetchType.LAZY) //добавила аннотацию
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop") //добавила аннотацию, однонаправленная связь
    private List<Discount> discounts;

    //TODO добавить ассоциацию @OneToMany с купонами. Их тоже магазин выдаёт

    //TODO добавить ассоциацию с CartItem. См. RedMe
}
