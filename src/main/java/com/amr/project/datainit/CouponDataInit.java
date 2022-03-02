package com.amr.project.datainit;

import com.amr.project.dao.abstracts.CouponDao;
import com.amr.project.model.entity.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CouponDataInit {

    private final CouponDao couponDao;

    @Autowired
    private CouponDataInit(CouponDao couponDao) {
        this.couponDao = couponDao;
    }

    @PostConstruct
    private void couponDataInit() {
        couponDao.persist(Coupon.builder().id(1L).discount(10).minOrder(200).name("Black Friday").isUsed(false).build());
        couponDao.persist(Coupon.builder().id(2L).discount(15).minOrder(300).name("Black Friday").isUsed(false).build());
        couponDao.persist(Coupon.builder().id(3L).discount(25).minOrder(500).name("Black Friday").isUsed(false).build());
        couponDao.persist(Coupon.builder().id(4L).discount(10).minOrder(250).name("Red Sunday").isUsed(false).build());
        couponDao.persist(Coupon.builder().id(5L).discount(20).minOrder(600).name("Red Sunday").isUsed(false).build());
        couponDao.persist(Coupon.builder().id(6L).discount(30).minOrder(100).name("Red Sunday").isUsed(false).build());
        couponDao.persist(Coupon.builder().id(7L).discount(50).minOrder(1000).name("Only for man").isUsed(false).build());
    }
}
