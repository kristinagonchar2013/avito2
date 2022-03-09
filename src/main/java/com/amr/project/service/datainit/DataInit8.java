package com.amr.project.service.datainit;

import com.amr.project.model.entity.*;
import com.amr.project.service.abstracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInit8 {
    private final DiscountService discountService;
    private final UserService userService;
    private final ShopService shopService;

    @Autowired
    public DataInit8(DiscountService discountService, UserService userService, ShopService shopService) {
        this.discountService = discountService;
        this.userService = userService;
        this.shopService = shopService;
    }

    @PostConstruct
    private void discountDataInit() {
        discountService.persist(Discount.builder().minOrder(150).percentage(5)
                .user(userService.findById(1L))
                .shop(shopService.findById(1L))
                .build());
        discountService.persist(Discount.builder().minOrder(350).percentage(15)
                .user(userService.findById(1L))
                .shop(shopService.findById(1L))
                .build());
        discountService.persist(Discount.builder().minOrder(220).percentage(10)
                .shop(shopService.findById(1L))
                .build());
        discountService.persist(Discount.builder().minOrder(380).percentage(25)
                .user(userService.findById(4L))
                .shop(shopService.findById(2L))
                .build());
        discountService.persist(Discount.builder().minOrder(1000).percentage(50)
                .shop(shopService.findById(3L))
                .build());
        discountService.persist(Discount.builder().minOrder(800).percentage(60)
                .shop(shopService.findById(4L))
                .build());
        discountService.persist(Discount.builder().minOrder(100).percentage(2)
                .user(userService.findById(4L))
                .shop(shopService.findById(2L))
                .build());
        discountService.persist(Discount.builder().minOrder(750).percentage(13)
                .shop(shopService.findById(3L))
                .build());
    }
}
