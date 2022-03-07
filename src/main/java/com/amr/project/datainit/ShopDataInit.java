package com.amr.project.datainit;

import com.amr.project.dao.abstracts.*;
import com.amr.project.model.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class ShopDataInit {

    private final ShopDao shopDao;
    private final CityDao cityDao;
    private final UserDao userDao;
    private final DiscountDao discountDao;
    private final CouponDao couponDao;

    @Autowired
    public ShopDataInit(ShopDao shopDao, CityDao cityDao, UserDao userDao, DiscountDao discountDao, CouponDao couponDao) {
        this.shopDao = shopDao;
        this.cityDao = cityDao;
        this.userDao = userDao;
        this.discountDao = discountDao;
        this.couponDao = couponDao;
    }

    @PostConstruct
    private void shopDataInit() {
        shopDao.persist(Shop.builder().name("Chairs & Co")
                .email("chairs.co@gmail.com").phone("11111111")
                .description("You will find what you want").rating(4.44)
                .isModerated(true).isModerateAccept(true).moderatedRejectReason("adding")
                .location(cityDao.findById(1L))
                .user(userDao.findById(1L))
                .discounts(List.of(discountDao.findById(1L)))
                .coupons(List.of(couponDao.findById(1L), couponDao.findById(4L), couponDao.findById(7L))).build());

        shopDao.persist(Shop.builder().name("Mr.Table")
                .email("table.and.brothers@gmail.com").phone("22222222")
                .description("It's best of the best of the best").rating(5.00)
                .isModerated(true).isModerateAccept(true).moderatedRejectReason("adding")
                .location(cityDao.findById(2L))
                .user(userDao.findById(1L))
                .discounts(discountDao.findAll())
                .coupons(List.of(couponDao.findById(2L), couponDao.findById(5L))).build());

        shopDao.persist(Shop.builder().name("Active Sport Shop")
                .email("sportforever.com").phone("333333333")
                .description("We love sport").rating(4.89)
                .isModerated(true).isModerateAccept(true).moderatedRejectReason("adding")
                .location(cityDao.findById(3L))
                .user(userDao.findById(4L))
                .discounts(List.of(discountDao.findById(2L), discountDao.findById(4L)))
                .coupons(List.of(couponDao.findById(3L), couponDao.findById(6L))).build());

        shopDao.persist(Shop.builder().name("Only Mobile")
                .email("worldofmobile.net").email("444444444")
                .description("We call you!").rating(3.2)
                .isModerated(true).isModerateAccept(true).moderatedRejectReason("adding")
                .location(cityDao.findById(4L))
                .user(userDao.findById(4L))
                .discounts(List.of(discountDao.findById(3L)))
                .build());
    }
}
