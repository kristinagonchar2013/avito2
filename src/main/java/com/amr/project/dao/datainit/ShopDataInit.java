package com.amr.project.dao.datainit;

import com.amr.project.dao.abstracts.*;
import com.amr.project.model.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class ShopDataInit {

    private final ShopDao shopDao;
    private final CityDao cityDao;
    private final ItemDao itemDao;
    private final ReviewDao reviewDao;
    private final DiscountDao discountDao;

    @Autowired
    public ShopDataInit(ShopDao shopDao, CityDao cityDao, ItemDao itemDao, ReviewDao reviewDao, DiscountDao discountDao) {
        this.shopDao = shopDao;
        this.cityDao = cityDao;
        this.itemDao = itemDao;
        this.reviewDao = reviewDao;
        this.discountDao = discountDao;
    }

    @PostConstruct
    public void shopDataInit() {
        shopDao.persist(Shop.builder().id(1L).name("Chairs & Co").location(cityDao.findById(1L))
                .email("chairs.co@gmail.com").phone("11111111").rating(4.44)
                .items(Arrays.asList(itemDao.findById(7L), itemDao.findById(8L))).isModerated(true)
                .reviews(Arrays.asList(reviewDao.findById(15L)))
                .discounts(Arrays.asList(discountDao.findById(1L))).build());
        shopDao.persist(Shop.builder().id(2L).name("Mr.Table").location(cityDao.findById(2L))
                .email("table.and.brothers@gmail.com").phone("22222222").rating(5.00).isModerated(true)
                .items(Arrays.asList(itemDao.findById(1L), itemDao.findById(2L)))
                .reviews(Arrays.asList(reviewDao.findById(14L)))
                .discounts(discountDao.findAll()).build());
        shopDao.persist(Shop.builder().id(3L).name("Active Sport Shop").location(cityDao.findById(3L))
                .email("sportforever.com").phone("333333333").rating(4.89).isModerated(true)
                .items(Arrays.asList(itemDao.findById(5L), itemDao.findById(6L)))
                .reviews(Arrays.asList(reviewDao.findById(13L)))
                .discounts(Arrays.asList(discountDao.findById(2L), discountDao.findById(4L))).build());
        shopDao.persist(Shop.builder().id(4L).name("Only Mobile").location(cityDao.findById(4L))
                .email("worldofmobile.net").email("444444444").rating(3.2).isModerated(true)
                .items(Arrays.asList(itemDao.findById(3L), itemDao.findById(4L)))
                .reviews(Arrays.asList(reviewDao.findById(12L)))
                .discounts(Arrays.asList(discountDao.findById(3L))).build());
    }
}
