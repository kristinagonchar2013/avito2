package com.amr.project.service.datainit;

import com.amr.project.model.entity.Coupon;
import com.amr.project.service.abstracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class DataInit6 {

    private final CouponService couponService;
    private final ShopService shopService;
    private final UserService userService;

    @Autowired
    public DataInit6(CouponService couponService, ShopService shopService, UserService userService) {
        this.couponService = couponService;
        this.shopService = shopService;
        this.userService = userService;
    }

    @PostConstruct
    private void couponDataInit() {
        couponService.persist(Coupon.builder().discount(10).minOrder(200).name("Black Friday").isUsed(false)
                .shop(shopService.findById(1L)).build());
        couponService.persist(Coupon.builder().discount(15).minOrder(300).name("Black Friday").isUsed(false)
                .shop(shopService.findById(2L))
                .user(userService.findById(1L)).build());
        couponService.persist(Coupon.builder().discount(25).minOrder(500).name("Black Friday").isUsed(false)
                .shop(shopService.findById(3L))
                .user(userService.findById(4L)).build());
        couponService.persist(Coupon.builder().discount(10).minOrder(250).name("Red Sunday").isUsed(false)
                .shop(shopService.findById(4L))
                .user(userService.findById(1L)).build());
        couponService.persist(Coupon.builder().discount(20).minOrder(600).name("Red Sunday").isUsed(false)
                .shop(shopService.findById(1L)).build());
        couponService.persist(Coupon.builder().discount(30).minOrder(100).name("Red Sunday").isUsed(false)
                .shop(shopService.findById(2L)).build());
        couponService.persist(Coupon.builder().discount(50).minOrder(1000).name("Only for man").isUsed(false)
                .shop(shopService.findById(3L))
                .user(userService.findById(1L)).build());
    }
}
