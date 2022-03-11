package com.amr.project.service.datainit;

import com.amr.project.model.entity.Chat;
import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class DataInit5 {

    private final CategoryService categoryService;
    private final ItemService itemService;
    private final ShopService shopService;
    private final ChatService chatService;
    private final UserService userService;

    @Autowired
    public DataInit5(CategoryService categoryService, ItemService itemService, ShopService shopService, ChatService chatService, UserService userService) {
        this.categoryService = categoryService;
        this.itemService = itemService;
        this.shopService = shopService;
        this.chatService = chatService;
        this.userService = userService;
    }

    @PostConstruct
    private void itemDataInit() {
        itemService.persist(Item.builder().name("White Wooden Table")
                .basePrice(BigDecimal.valueOf(150)).price(BigDecimal.valueOf(125.6))
                .count(19).rating(4)
                .description("The best of the best").discount(5)
                .isModerated(true).moderatedRejectReason("adding")
                .category(categoryService.findById(1L))
                .category(categoryService.findById(9L))
                .shop(shopService.findById(2L))
                .build());

        itemService.persist(Item.builder().name("Black Wooden Table")
                .basePrice(BigDecimal.valueOf(250)).price(BigDecimal.valueOf(225.3))
                .count(3).rating(4.95)
                .description("You realy looked only for this!").discount(10)
                .isModerated(true).moderatedRejectReason("adding")
                .category(categoryService.findById(1L))
                .category(categoryService.findById(9L))
                .shop(shopService.findById(2L))
                .build());

        itemService.persist(Item.builder().name("IPhone 15R")
                .basePrice(BigDecimal.valueOf(400)).price(BigDecimal.valueOf(350.6))
                .count(10).rating(4.0)
                .description("Final version").discount(1)
                .isModerated(true).moderatedRejectReason("adding")
                .category(categoryService.findById(2L))
                .category(categoryService.findById(6L))
                .shop(shopService.findById(4L))
                .build());

        itemService.persist(Item.builder().name("Nokia 3310")
                .basePrice(BigDecimal.valueOf(212)).price(BigDecimal.valueOf(200))
                .count(2).rating(5)
                .description("The oldest phone in whole world").discount(66)
                .isModerated(true).moderatedRejectReason("adding")
                .category(categoryService.findById(2L))
                .category(categoryService.findById(6L))
                .shop(shopService.findById(4L))
                .build());

        itemService.persist(Item.builder().name("Adult Bicycle")
                .basePrice(BigDecimal.valueOf(180)).price(BigDecimal.valueOf(176.1))
                .count(1).rating(4.62)
                .description("Its only bicycle").discount(25)
                .isModerated(true).moderatedRejectReason("adding")
                .category(categoryService.findById(1L))
                .category(categoryService.findById(8L))
                .shop(shopService.findById(3L))
                .build());

        itemService.persist(Item.builder().name("Child Pink Bicycle")
                .basePrice(BigDecimal.valueOf(150)).price(BigDecimal.valueOf(130))
                .count(6).rating(4.12)
                .description("Pink for really honeys").discount(25)
                .isModerated(true).moderatedRejectReason("adding")
                .category(categoryService.findById(1L))
                .category(categoryService.findById(7L))
                .shop(shopService.findById(3L))
                .build());

        itemService.persist(Item.builder().name("Swedish Chairs")
                .basePrice(BigDecimal.valueOf(210.09))
                .price(BigDecimal.valueOf(200.55))
                .count(20).rating(5.0)
                .description("I know? you want their").discount(0)
                .isModerated(true).moderatedRejectReason("adding")
                .category(categoryService.findById(4L))
                .category(categoryService.findById(9L))
                .shop(shopService.findById(1L))
                .build());

        itemService.persist(Item.builder().name("Chairs for Children")
                .basePrice(BigDecimal.valueOf(188.23))
                .price(BigDecimal.valueOf(180))
                .count(40).rating(4.99)
                .description("For little brothers and sisters").discount(33)
                .isModerated(true).moderatedRejectReason("adding")
                .category(categoryService.findById(4L))
                .category(categoryService.findById(7L))
                .category(categoryService.findById(9L))
                .shop(shopService.findById(1L))
                .build());
    }

    @PostConstruct
    private void chatDataInit() {
        chatService.persist(Chat.builder()
                .member(userService.findById(1L))
                .member(userService.findById(2L))
                .build());
        chatService.persist(Chat.builder()
                .member(userService.findById(1L))
                .member(userService.findById(3L))
                .build());
        chatService.persist(Chat.builder()
                .member(userService.findById(1L))
                .member(userService.findById(4L))
                .build());
        chatService.persist(Chat.builder()
                .member(userService.findById(3L))
                .member(userService.findById(4L))
                .build());
    }
}
