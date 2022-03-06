package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "cart_items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    // аннотация generatedvalue не нужна, его айди будет подгружаться от поля юзер через аннотацию joinColumn
    private Long id;
    private String anonID;
    private BigInteger totalPrice; //итоговая сумма должна отражаться в корзине
    //убрала поле количества товаров, они все будут в листе товаров

    //TODO CartItem - это не корзина как таковая, а товар в корзине,товар для корзины, который обрастает такими
    // подробностями для его идентификации и расчёта стоимости. Может вернуть количество, сделать связь с Item как
    // OneToOne.
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId // аннотация, для подгружения айдишника юзера
    @JoinColumn(name = "id") //для подгрузки айди юзера и совпадением с айди корзины
    private User user;

    @OneToMany(fetch = FetchType.LAZY) //однонаправленная связь
    @JoinColumn(name = "item_id")
    private List<Item> items;
}
